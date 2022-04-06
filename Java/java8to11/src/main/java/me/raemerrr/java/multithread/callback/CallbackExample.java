package me.raemerrr.java.multithread.callback;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {

    private ExecutorService executorService;

    public CallbackExample() {
        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    private CompletionHandler<Integer, Void> callback = new CompletionHandler<>() {
        @Override
        public void completed(Integer result, Void attachment) {
            System.out.println("completed() 실행 : " + result);
        }

        @Override
        public void failed(Throwable exc, Void attachment) {
            System.out.println("failed() 실행 : " + exc.toString());
        }
    };

    public void doWork(final String x, final String y) {
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    int intX = Integer.parseInt(x);
//                    int intY = Integer.parseInt(y);
//                    int result = intX + intY;
//                    callback.completed(result, null); // 정상 처리
//                } catch (NumberFormatException e) {
//                    callback.failed(e, null); // 실패 처리
//                }
//            }
//        };
        Runnable task = () -> {
            try {
                int intX = Integer.parseInt(x);
                int intY = Integer.parseInt(y);
                int result = intX + intY;
                callback.completed(result, null); // 정상 처리
            } catch (NumberFormatException e) {
                callback.failed(e, null); // 실패 처리
            }
        };
        executorService.submit(task);
    }

    public void finish() {
        executorService.shutdown();
    }

    public void main(String[] args) {
        CallbackExample example = new CallbackExample();
        example.doWork("3", "3");
        example.doWork("3", "삼");
        example.finish();
    }

}
