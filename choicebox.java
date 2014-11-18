
import java.awt.*;
import java.applet.*;
//import java.awt.event.*;
import java.util.Date;


public class choicebox extends Applet 
		{

			Choice month,year;

			Label monthLabel = new Label("month:");
			Label yearLabel = new Label("Year:");
			Button selectButton =new Button("Select calendar");
			
			String days[] = {"Sun", "Mon", "Tue", "Wed",
				   "Thu", "Fri", "Sat"};

			Font smallFont = new Font("Times New Romans", Font.PLAIN, 15);
			Font largeFont = new Font("Arial", Font.BOLD, 30);

			String strmonth;
			String stryear;
			String strday;
			int IntYear;
		   
			int Intday[];
			int Intmonth;
			int i,j,k,l,m,p=40,q=110,d=0,a;
			int add,firstday=6,lastday,leapyear;
			int date[][];

			String months[]={"January","February","March","April","May","june","July","August",
						   "september","October","November","December"};

			String years[]={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
						  "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};

			String lastdayofmonth[]={"31","28","31","30","31","30","31","31","30","31","30","31"};

			Date now = new Date();
			int userMonth;
			int userYear;
			int userDate;
			int userDay;
			int userday;
			int userHour;
			int userMinute;
		   

			public void init()
				{
				userMonth = now.getMonth();
				userYear  = now.getYear()+1900;
				userDate =now.getDate();
				userDay =now.getDay();
				userHour =now.getHours();
				userMinute =now.getMinutes();
				setSize(500,500);

				month = new Choice();
				year = new Choice();

				add(monthLabel);
				for(i=0;i<12;i++)
				month.add(months[i]);

				month.select(userMonth);
				add(month);
				
				add(yearLabel);
				for(i=0;i<=20;i++)
				year.add(years[i]);
			
				year.select(String.valueOf(userYear));
				add(year);				

				add(selectButton);
				}
			 
			
			 public void conver()
				{
				 for(i=0;i<12;i++)
					 if(userMonth==i)
						 strmonth=months[i];
				}


			  public void paint(Graphics g)
				{
					k=20;l=90;m=5;
					for(int i=0;i<7;i++)
						{
						g.drawString(days[i],k,80);
						k=k+55;
						}
					g.drawLine(5,60,390,60);
					g.drawString(""+userDate+"   "+userDay+"   "+userHour+":"+userMinute,10,400);
					
					g.drawString(""+userDate,10,420);
					for(int i=1;i<=6;i++)
						{
						g.drawLine(5, l, 390, l);
						l=l+41;
						}

					for(int i=1;i<=8;i++)
						{
						g.drawLine(m, 60, m, 295);
						m=m+55;
						}

				strmonth=month.getSelectedItem();
				stryear=year.getSelectedItem();

				IntYear=Integer.parseInt(year.getSelectedItem());						   
				g.drawString(""+IntYear+" "+strmonth, 10, 440);
			  
				lastday=Integer.parseInt(lastdayofmonth[a]);

				for(k=0;k<5;k++)
					 {
					  for(l=1;l<=7;l++)
						  {
						   date[k][l]=7*k+l-firstday;
						   if(date[k][l]>0)
							  if(date[k][l]<10)
								 g.drawString("0"+date[k][l],p, q);
							  else
								 if(date[k][l]<=lastday)
									g.drawString(""+date[k][l], p, q);
								 p=p+50;
						  }
						   p=40;
						   q=q+40;									 
					 }
				g.drawString("Selected  month:  "+strmonth,30,48);
				g.drawString("Selected year:  "+stryear,200,48);
				firstday=calculateFirstmonth(IntYear,userMonth);
				}


			  public boolean action(Event e,Object o)
				{
				 if (e.target instanceof Button)
						{
						   if ("select calendar".equals((String)o))
								{
									userMonth = month.getSelectedIndex();
									IntYear = Integer.parseInt(year.getSelectedItem());
									userYear = IntYear;

									repaint();
									return true;
								}
							repaint();
						 }
				 return false;
				}


			   int calculateFirstmonth(int year, int month)
					{
					 leapyear=year%4;
					 if(leapyear==0)
						add=1;
					 for(i=0;i<=20;i++)
						{
						 for(j=0;j<12;j++)
							{
							 lastday=Integer.parseInt(lastdayofmonth[i]);
							 a=j;
							 if(month==j)
								break;
							 firstday=(firstday+lastday)%7;
							}
						 if(year==i)
						   break;
						}
					 return firstday;
					}
		}