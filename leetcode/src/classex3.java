public class classex3 {
    static class CountingThread extends Thread {
        /**
         * Static fields
         */
        volatile static int counter = 0;

        synchronized static void increaseCounter() {
            counter++;
        }

        public static int getCounter() {
            return counter;
        }

        @Override
        public void run() {
            running = true;
            for (int i = 0; i < iterations; i++) {
                increaseCounter();
            }
            running = false;
        }


    }
