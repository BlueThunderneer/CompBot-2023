package frc.robot.subsystems;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.TalonSRXSimCollection;
import com.ctre.phoenix.motorcontrol.GroupMotorControllers;


//Remove comment flags for all spark max items and comment talon lines to switch to the neo moving the arm
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;




public class ClawSS extends SubsystemBase{
    /*private TalonSRX talon0;
    private TalonSRX talon1;*/
    private DoubleSolenoid DS1;
    private DoubleSolenoid DS2;
    Compressor air;
    //private CANSparkMax m_sMax;


public ClawSS() {
   /* talon0 = new TalonSRX(30); 
    talon1 = new TalonSRX(31);
    talon1.set(ControlMode.Follower, talon0.getDeviceID()); */
    DS1 = new DoubleSolenoid(6, PneumaticsModuleType.CTREPCM, 0, 1); //0 is forward and 1 is reverse 
    DS2 = new DoubleSolenoid(6, PneumaticsModuleType.CTREPCM, 2, 3); //2 is forward and 3 is reverse
    air = new Compressor(6, PneumaticsModuleType.CTREPCM);
    
    //m_sMax = new CANSparkMax(33, MotorType.kBrushless);
    //m_sMax.restoreFactoryDefaults();
 }



public void OpenClaw(){
  //  talon0.set(ControlMode.PercentOutput, 0.75);
    //m_sMax.set(.5);

    DS1.set(kForward);
    DS2.set(kForward); 
    
}



public void airOFF(){
  air.disable();
}

public void airON(){
  air.enableDigital();
}



public void initialize(){
    //DO NOTHING SO WE DO NOT MOVE THE ARM UNEXPECTEDLY

}

public void CloseClaw(){

    //talon0.set(ControlMode.PercentOutput, -0.75);
    //m_sMax.set(-0.5);
    // talon0.set(ControlMode.PercentOutput, -0.75);

   DS1.set(kReverse);
   DS2.set(kReverse); 
}

public void stop() {
    //talon0.set(ControlMode.PercentOutput, 0.0);

    //m_sMax.set(0);
    
    //DO NOTHING SO WE DO NOT MOVE THE ARM UNEXPECTEDLY

  } 
}
