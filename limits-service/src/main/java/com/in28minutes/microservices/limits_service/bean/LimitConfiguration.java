package com.in28minutes.microservices.limits_service.bean;

public class LimitConfiguration //2nd
{
  private	int maximum;
  private	int minimum;
	public int getMaximum() 
	{
		return maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	
	  protected  LimitConfiguration()
	{
		
	}
	
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	@Override
	public String toString() {
		return "LimitConfiguration [maximum=" + maximum + ", minimum=" + minimum + "]";
	}

}
