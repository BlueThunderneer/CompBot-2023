package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants.DriveConstants;


public class ArmSS extends SubsystemBase{

        private CANSparkMax m_sMax;
        private CANSparkMax m_sMax2;
        private double m_armSpeed;


       // private SparkMaxPIDController m_PidController;
       // public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
        private RelativeEncoder m_encoder;
        private RelativeEncoder m_rotencoder;

        //Compressor air;

        
        public ArmSS(){
            //Arm Rotate motor
            m_sMax = new CANSparkMax(15, MotorType.kBrushless);
            m_sMax.restoreFactoryDefaults();
            m_sMax.setInverted(true);
            m_rotencoder = m_sMax.getEncoder(Type.kHallSensor,42);
            //arm Telescope motor
            m_sMax2 = new CANSparkMax(33, MotorType.kBrushless );
            m_sMax2.restoreFactoryDefaults();
            m_encoder = m_sMax2.getEncoder(Type.kHallSensor,42);

            //m_PidController = m_sMax.getPIDController();

          

            /*kP = 0.1; 
            kI = 1e-4;
            kD = 1; 
            kIz = 0; 
            kFF = 0; 
            kMaxOutput = 1; 
            kMinOutput = -1;

            m_PidController.setP(kP);
            m_PidController.setI(kI);
            m_PidController.setD(kD);
            m_PidController.setIZone(kIz);
            m_PidController.setFF(kFF);
            m_PidController.setOutputRange(kMinOutput, kMaxOutput);

            SmartDashboard.putNumber("P Gain", kP);
            SmartDashboard.putNumber("I Gain", kI);
            SmartDashboard.putNumber("D Gain", kD);
            SmartDashboard.putNumber("I Zone", kIz);
            SmartDashboard.putNumber("Feed Forward", kFF);
            SmartDashboard.putNumber("Max Output", kMaxOutput);
            SmartDashboard.putNumber("Min Output", kMinOutput);
            SmartDashboard.putNumber("Set Rotations", 0);*/

        }


    @Override

    public void periodic(){
      // read PID coefficients from SmartDashboard
      /* 
      double p = SmartDashboard.getNumber("P Gain", 0);
      double i = SmartDashboard.getNumber("I Gain", 0);
      double d = SmartDashboard.getNumber("D Gain", 0);
      double iz = SmartDashboard.getNumber("I Zone", 0);
      double ff = SmartDashboard.getNumber("Feed Forward", 0);
      double max = SmartDashboard.getNumber("Max Output", 0);
      double min = SmartDashboard.getNumber("Min Output", 0);
      */
      double rotations = SmartDashboard.getNumber("Set Rotations", 0);
    
      // if PID coefficients on SmartDashboard have changed, write new values to controller

        SmartDashboard.putNumber("SetPoint", rotations);
        SmartDashboard.putNumber("Rot Current", m_sMax.getOutputCurrent());
        SmartDashboard.putNumber("Telescope Current",m_sMax2.getOutputCurrent());
        SmartDashboard.putNumber("Telescope Pos", m_encoder.getPosition());
        SmartDashboard.putNumber("Rotation Pos", m_rotencoder.getPosition()*-1);

    }
  /** Resets the Telescope encoder to currently read a position of 0. */
  public void resetArmEncoder() {
    m_encoder.setPosition(0);
  }

 /** Resets the Rotation encoders to currently read a position of 0. */
 public void resetArmRotEncoder() {
    m_rotencoder.setPosition(0);
  }

  public void ArmMove(double armSpeed) {
        if (armSpeed < 0 ) {
            if(m_rotencoder.getPosition()*-1 < 170  ){
                m_armSpeed=armSpeed*armSpeed*-1;
                m_sMax.set(m_armSpeed);
                }
            else {m_sMax.set(0);}
        }
        else {              
            if(m_rotencoder.getPosition()*-1 > -78 ){
                m_armSpeed=armSpeed*armSpeed;
                m_sMax.set(m_armSpeed);
                }
            else {m_sMax.set(0);}
        }
}

  public void ArmUp(){
    m_sMax.set(0.5);
    }
  
    public void ArmDown(){
    m_sMax.set(-0.7);
    }

    public void ArmIn()
    {
    if (m_encoder.getPosition() < 20) {
        m_sMax2.set(0);
    } else {
        m_sMax2.set(-1);
    }
}
  
    public void ArmOut(){
        if (m_encoder.getPosition() > 260) {
            m_sMax2.set(0);
        } else {
            m_sMax2.set(1);
        }
    }


    public void stop() {
        m_sMax2.set(0);

        // set to 0 velocity when stop
    }

    public void armrotstop() {
        m_sMax.set(0);

        // set to 0 velocity when stop
    }
}