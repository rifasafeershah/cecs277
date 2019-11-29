
package cecs277DemoMementoPattern;

import java.util.Stack;

/**
 * The Section is the class whose state we manage in the memento.
 * @author Michael Zaragoza and Rifa Safeer Shah
 * @date 21 October 2019
 */
public class Section {
	/** The name of the course */
	String courseName;
	/** The section number of this particular section */
	int sectionNumber;
	/** The name of the instructor */
	String instructorName;
	/** The start time name */
	Time startTime;
	/** The end time name */
	Time endTime;
	/** The day of the course section */
	Time day;
	/** The Building where this section is held */
	String Building;
	/** The room number of this section */
	String Room;
	
	/** This includes course information */
	public Section(String courseName, int sectionNumber, String instructorName, Time startTime, Time endTime, Time day, String building,
			String room) {
		super();
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
		this.instructorName = instructorName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
		Building = building;
		Room = room;
	}
	
	@Override
	public String toString() {
		return "Section [courseName=" + courseName + ", sectionNumber=" + sectionNumber + ", instructorName=" + instructorName + ", startTime="
				+ startTime + ", endTime=" + endTime + ", day=" + day + ", Building=" + Building + ", Room=" + Room + "]";
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	} //ends setCourseName
	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	} //ends sectionNumber
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	} //ends setInstructorName
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	} //ends setStartTime
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	} //ends setEndTime
	public void setDay(Time day) {
		this.day = day;
	} //ends setDay
	public void setBuilding(String building) {
		Building = building;
	} //ends setBuilding
	public void setRoom(String room) {
		Room = room;
	} //ends setRoom
	
	/** gets information from the memento */
	public void getStateFromMemento (Memento mem) {
		this.courseName = mem.getCourseName();
		this.sectionNumber = mem.getSectionNumber();
		this.instructorName = mem.getInstructorName();
		this.startTime = mem.getStartTime();
		this.endTime = mem.getEndTime();
		this.day = mem.getDay();
		this.Building = mem.getBuilding();
		this.Room = mem.getRoom();
	}
	
	/**
	 * Pickle the current state into an instance of Memento and return it.
	 * @return	The memento copy of the present state.
	 */
	public Memento saveStatetoMemento () {
		return new Memento (this.courseName, this.sectionNumber, this.instructorName, this.startTime, this.endTime, this.day, this.Building, this.Room);
	}
	
	/** 
	 * The one who manages the Memento objects and doles them out as required.
	 * I could have made a separate class out of this, but then you could run into the problem
	 * of one instance of the CareTaker mixing mementos from different instances of Section,
	 * which would never do.  This nested class is NOT static, so it must be associated with
	 * a particular instance of the enclosing class: Section.
	 * @author Michael Zaragoza and Rifa Safeer Shah
	 * @date 21 October 2019
	 */
	public class CareTaker {
		private Stack <Memento> mStack = new Stack <> ();
		
		public void add() {
			//Use the enclosing class's saveStatetoMemento() method to create a fresh memento 
			//instance.  We know this CareTaker has to belong to a specific instance of Section,
			//and we only want mementos from that Section.
			Memento memento = saveStatetoMemento();
			mStack.add(memento);
		}
		
		/** 
		 * Retrieve the most recently added version.  There could be any number of 
		 * ways to designate which memento you wanted.  We could pass in an index 
		 * number (use an ArrayList instead of a stack in that case), or use a lookup
		 * process to find the memento that matches specific characteristics, or 
		 * any of a number of things.  The important thing to this design pattern is
		 * that we have some way to indicate which memento we want.  In this case, 
		 * it is the most recent one.
		 * @return	The most recent memento.
		 */
		public Memento get() {
			return mStack.pop();
		}
	}

}
