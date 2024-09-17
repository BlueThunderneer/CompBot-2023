package frc.robot.commands;
import frc.robot.subsystems.CannonSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Fill extends CommandBase {
    private final CannonSS m_cannonss; 

    public Fill(CannonSS subsystem){

        m_cannonss = subsystem;
        addRequirements(m_cannonss);
    }


    @Override
    public void initialize(){
        m_cannonss.Fill();
    }

    @Override 
    public void end(boolean interupted){
        m_cannonss.fillstop();
    }
}
