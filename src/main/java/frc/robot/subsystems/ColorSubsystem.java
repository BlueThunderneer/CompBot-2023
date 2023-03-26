package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class ColorSubsystem extends SubsystemBase {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_cs = new ColorSensorV3(i2cPort);  
    public AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(44); 
    public AddressableLED m_led = new AddressableLED(9);

    public ColorSubsystem(){
        // Length is expensive to set, so only set it once, then just update data
        m_led.setLength(m_ledBuffer.getLength());
        // Set the data
        m_led.setData(m_ledBuffer);
        m_led.start();
    }
  


    @Override
    public void periodic() {
        int proximity = m_cs.getProximity();
        SmartDashboard.putNumber("Cubedistance", proximity);



        
//
 

        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            if (proximity > 150){
                // green
                m_ledBuffer.setRGB(i, 0, 255, 0);

            }
            else{
                // red
                m_ledBuffer.setRGB(i, 255, 0, 0);

            }
            // Sets the specified LED to the RGB values for green
         }
    
         //after if else send color to leds.
     m_led.setData(m_ledBuffer);
    }
}
