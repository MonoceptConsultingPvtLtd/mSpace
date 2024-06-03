package com.genericutility;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.reactivex.rxjava3.exceptions.Exceptions;

public class DriverActionUtility 
{

	WebDriver driver;
	
	public void clickOnElement(WebElement element) throws IOException
	{
		try 
		{
			element.click();
		}
		 catch(Exception e)
		 {
			// Capture screenshot
			 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			 // Find WebElement coordinates
			 Point location = element.getLocation();
			 Dimension size = element.getSize();

			 // Load screenshot image
			 BufferedImage image = ImageIO.read(screenshot);

			 // Draw highlight marker
			 Graphics2D graphics = image.createGraphics();
			 graphics.setColor(Color.RED);
			 graphics.drawRect(location.getX(), location.getY(), size.getWidth(), size.getHeight());

			 // Save modified screenshot
			 File output = new File("highlighted_screenshot.png");
			
			

		 }
	}
	
	
}
