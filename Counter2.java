class Counter2 implements Runnable {

    double waitingTime = 0;
    Thread myCounter = new Thread(this);

    public Counter2(double waitingTime)
    {
        this.waitingTime = waitingTime;
        new Thread(this).start();
    }

    public void run(){

        //Start countdown:
        do  
        {

            waitingTime -= 1;

            try {

                Thread.sleep(1000);
                //System.out.println(waitingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (waitingTime >= 0);


     

        GameRunner.frame.initializeCenter();
        Counter c = new Counter(0);
    }
}
