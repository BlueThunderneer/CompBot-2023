package frc.robot.commands;
import frc.robot.subsystems.ClawSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class OpenClaw extends CommandBase {
    private final ClawSS m_clawss; 

    public OpenClaw(ClawSS subsystem){

        m_clawss = subsystem;
        addRequirements(m_clawss);
    }


    @Override
    public void initialize(){
        m_clawss.OpenClaw();
    }

    @Override 
    public void end(boolean interupted){
        m_clawss.stop();
    }
}
