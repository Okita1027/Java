package juc.thread_pool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author qzy
 * @time 2023/12/6 16:22 星期三
 * @title
 */
public class CompletableFutureDemo {

    /**
     * 主线程里面创建一个 CompletableFuture，然后主线程调用 get 方法会阻塞，最后我们在一个子线程中使其终止
     */
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "子线程开始干活");
                //子线程睡 5 秒
                Thread.sleep(5000);
                //在子线程中完成主线程
                future.complete("success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        //主线程调用 get 方法阻塞
        System.out.println("主线程调用 get 方法获取结果为: " + future.get());
        System.out.println("主线程完成,阻塞结束!");
    }

    @Test
    void noReturnAsyTask() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        //运行一个没有返回值的异步任务
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("子线程启动干活");
                Thread.sleep(5000);
                System.out.println("子线程完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //主线程阻塞
        future.get();
        System.out.println("主线程结束");
    }

    @Test
    void returnAsyTask() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        //运行一个有返回值的异步任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("子线程开始任务");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "子线程完成了!";
        });
        //主线程阻塞
        String s = future.get();
        System.out.println("主线程结束, 子线程的结果为:" + s);
    }


    public static Integer num = 10;

    @Test
    void threadDependEach() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("加 10 任务开始");
                num += 10;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return num;
        }).thenApply(integer -> {
            return num * num;
        });
        Integer result = future.get();
        System.out.println("主线程结束, 子线程的结果为:" + result);
    }


    @Test
    void consumeResult() {
        System.out.println("主线程开始");
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("加 10 任务开始");
                num += 10;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return num;
        }).thenRun(() -> {
            System.out.println("Then Run num * num……");
        }).thenApply(integer -> {
            return num * num;
        }).thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer result) {
                System.out.println("子线程全部处理完成,最后调用了 accept,结果为:" + result);
            }
        });
    }

    @Test
    void dealWithException() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;  // 触发异常
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return -1;
        });
        System.out.println(future.get());
    }

    @Test
    void dealWithExceptionHandle() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(1 / 0);  // 引发异常
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        }).handle((i, ex) -> {
            System.out.println("进入 handle 方法");
            if (ex != null) {
                System.out.println("发生了异常,内容为:" + ex.getMessage());
                return -1;
            } else {
                System.out.println("正常完成,内容为: " + i);
                return i;
            }
        });
        System.out.println(future.get());
    }

    @Test
    void mergeResultThenCompose() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        //第一步加 10
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        });
        //合并
        CompletableFuture<Integer> future1 = future.thenCompose(i ->
                //再来一个 CompletableFuture
                CompletableFuture.supplyAsync(() -> {
                    return i + 1;
                }));
        System.out.println(future.get());
        System.out.println(future1.get());

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(future1, future);
        allFuture.get();
        System.out.println("Both futures are completed!");
    }

    @Test
    void thenCombine() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer> job1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        });
        CompletableFuture<Integer> job2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("乘以 10 任务开始");
            num = num * 10;
            return num;
        });
        //合并两个不相关任务的结果
        CompletableFuture<Object> future = job1.thenCombine(job2, new BiFunction<Integer, Integer, List<Integer>>() {
            @Override
            public List<Integer> apply(Integer a, Integer b) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(b);
                return list;
            }
        });
        System.out.println("合并结果为:" + future.get());
    }

    @Test
    void mergeMultiTaskResultAll() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        List<CompletableFuture> list = new ArrayList<>();
        CompletableFuture<Integer> job1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        });
        list.add(job1);
        CompletableFuture<Integer> job2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("乘以 10 任务开始");
            num = num * 10;
            return num;
        });
        list.add(job2);
        CompletableFuture<Integer> job3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("减以 10 任务开始");
            num = num * 10;
            return num;
        });
        list.add(job3);
        CompletableFuture<Integer> job4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("除以 10 任务开始");
            num = num * 10;
            return num;
        });
        list.add(job4);
        //多任务合并
        List<Integer> collect =
                list.stream().map(CompletableFuture<Integer>::join).collect(Collectors.toList());
        System.out.println(collect);

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(job1, job4, job3, job2);
        allFuture.get();
        System.out.println("所有任务都已完成，执行这段话！");
    }


    /**
     * 测试方法：合并多个异步任务，返回任意完成的任务结果
     * @throws ExecutionException 当执行任务出错时抛出的异常
     * @throws InterruptedException 当线程中断时抛出的异常
     */
    @Test
    void mergeMultiTaskAny() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");

        // 创建一个CompletableFuture数组
        CompletableFuture<Integer>[] futures = new CompletableFuture[4];

        // 创建第一个异步任务
        CompletableFuture<Integer> job1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("加 10 任务开始");
                num += 10;
                return num;
            } catch (Exception e) {
                return 0;
            }
        });

        // 将第一个异步任务存储在数组中
        futures[0] = job1;

        // 创建第二个异步任务
        CompletableFuture<Integer> job2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("乘以 10 任务开始");
                num = num * 10;
                return num;
            } catch (Exception e) {
                return 1;
            }
        });

        // 将第二个异步任务存储在数组中
        futures[1] = job2;

        // 创建第三个异步任务
        CompletableFuture<Integer> job3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("减以 10 任务开始");
                num = num * 10;
                return num;
            } catch (Exception e) {
                return 2;
            }
        });

        // 将第三个异步任务存储在数组中
        futures[2] = job3;

        // 创建第四个异步任务
        CompletableFuture<Integer> job4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("除以 10 任务开始");
                num = num * 10;
                return num;
            } catch (Exception e) {
                return 3;
            }
        });

        // 将第四个异步任务存储在数组中
        futures[3] = job4;

        // 合并异步任务，返回任意完成的任务结果
        CompletableFuture<Object> future = CompletableFuture.anyOf(futures);

        // 获取任意完成的任务结果
        System.out.println(future.get());
    }



}
