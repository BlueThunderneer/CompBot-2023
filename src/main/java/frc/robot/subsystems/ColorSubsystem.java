package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;


import com.revrobotics.*;
import com.revrobotics.Rev2mDistanceSensor.Port;

public class ColorSubsystem extends SubsystemBase {
    //private final Port i2cPort = I2C.Port.kOnboard;
    //public Rev2mDistanceSensor m_cs;  
    public AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(44); 
    public AddressableLED m_led = new AddressableLED(9);

    public ColorSubsystem(){
        //m_cs = new Rev2mDistanceSensor(Port.kOnboard); 
        //m_cs.setAutomaticMode(true);
        // Length is expensive to set, so only set it once, then just update data
        m_led.setLength(m_ledBuffer.getLength());
        // Set the data
        m_led.setData(m_ledBuffer);
        m_led.start();
    }
  


@Override
public void periodic() {
    //SmartDashboard.putNumber("Cubedistance", m_cs.getRange());
    for (var i = 0; i < m_ledBuffer.getLength(); i++) { 
        //green
       m_ledBuffer.setRGB(i, 230, 0, 255);
        }
         // if (m_cs.getRange() < 5.5 && m_cs.getRange() >1.5){
          //  for (var i = 0; i < m_ledBuffer.getLength(); i++) { 
                //green
             //  m_ledBuffer.setRGB(i, 230, 0, 255);
         //  }
       // } else if(m_cs.getRange() < 1.5 && m_cs.getRange() >0){
          //  for (var i = 0; i < m_ledBuffer.getLength(); i++) { 
                //green
             //  m_ledBuffer.setRGB(i, 255, 165, 0);
         //  }
       // }  else{
          //  for (var i = 0; i < m_ledBuffer.getLength(); i++) {
               // red
              // m_ledBuffer.setRGB(i, 255, 0, 0);

           //}
    //}
    
    //after if else send color to leds.
     m_led.setData(m_ledBuffer);
    
    //if(m_cs.isRangeValid())    {
        //double proximity = m_cs.getRange();
       // SmartDashboard.putNumber("Cubedistance", m_cs.getRange());
    //}       

    }
}
