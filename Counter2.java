import javax.swing.JPanel;

class Counter2 extends JPanel implements Runnable {

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

                Thread.sleep(10);
                //System.out.println(waitingTime);
            } catch (InterruptedException e) {

            }
        } while (waitingTime >= 0);


     
        GameRunner.frame.intro.setVisible(false);
        GameRunner.frame.initializeCenter();
        Counter c = new Counter(0);
    }
}
