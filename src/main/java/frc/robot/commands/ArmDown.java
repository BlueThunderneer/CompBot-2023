package frc.robot.commands;
import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArmDown extends CommandBase {
    private final ArmSS m_armss; 

    public ArmDown(ArmSS subsystem){

        m_armss = subsystem;
        addRequirements(m_armss);
    }


    @Override
    public void initialize(){
        m_armss.ArmDown();
    }

    @Override 
    public void end(boolean interupted){
        m_armss.armrotstop();
    }
}
