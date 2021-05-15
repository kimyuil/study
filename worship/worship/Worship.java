package worship;

import java.util.List;

import Persion.Persion;
import Process.ServiceProcess;

public abstract class Worship {
    
    protected List<Persion> member;
    protected List<ServiceProcess> process;
    private String name;
    private String day;    

    public Worship(){
    }
    public Worship(String name, String day){
        this.setName(name);
        this.setDay(day);
    }

    public abstract boolean assignPersion(List<Persion> member);

    public void progressService(){
        this.prepareWorship();
        this.serviceStart();
        this.cleanWorship();
        this.endWorship();
    }

    protected abstract void prepareWorship();
    
    protected abstract void serviceStart();
    
    protected abstract void cleanWorship();

    protected void endWorship(){
        this.member = null;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return this.name;
    }

    public String getDay() {
        return this.day;
    }

    private void setDay(String day) {
        this.day = day;
    }
}
