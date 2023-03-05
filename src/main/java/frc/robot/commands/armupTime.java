package frc.robot.commands;

import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class armupTime extends CommandBase{

    private final ArmSS m_ArmSS;

    private final double m_duration;

    private long m_startTime; 
    
    public armupTime(double time, ArmSS subsytem){
        m_ArmSS = subsytem;
        m_duration = time * 1000;
        addRequirements(m_ArmSS);
    }

    @Override
    public void initialize(){
        m_startTime = System.currentTimeMillis();
        m_ArmSS.ArmUp();
    }
    @Override
    public void end(boolean interrupted){
        m_ArmSS.stop();
    }
    @Override
    public boolean isFinished(){
        return(System.currentTimeMillis()-m_startTime)>= m_duration;
    }


}
