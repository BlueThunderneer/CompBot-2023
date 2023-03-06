package frc.robot.commands;
import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class ArmMove extends CommandBase {
    private final ArmSS m_armss; 
    private final Supplier<Double> m_armspeed;
    
    public ArmMove(
        ArmSS subsystem,
        Supplier<Double> armSpeed){
        m_armss = subsystem;
        m_armspeed = armSpeed;
        addRequirements(m_armss);
    }


    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        m_armss.ArmMove(m_armspeed.get());
    }

    @Override 
    public void end(boolean interupted){
        m_armss.armrotstop();
    }
}
