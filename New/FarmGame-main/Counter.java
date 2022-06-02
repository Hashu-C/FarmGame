class Counter implements Runnable {

    double waitingTime = 0;
    Thread myCounter = new Thread(this);

    public Counter(double waitingTime)
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


     
        
        GameFrame.pCenter.setVisible(true);
        GameFrame.p1.setVisible(true);
        GameFrame.triviaGame.setVisible(false);
        GameRunner.frame.getContentPane().add(GameFrame.pCenter, GameFrame.centerLayout);
		GameRunner.frame.getContentPane().add(GameFrame.p1,GameFrame.southLayout);
        GameRunner.frame.pack();

        /**
         * pCenter.setVisible(true);
         * p1.setVisible(true);
         * getContentPane().add(pCenter,centerLayout);
         * getContentPane().add(p1,southLayout);
         * pack();
         */
    }
}
