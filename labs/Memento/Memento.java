/**
 * The Memento Class gets the information about the instructor name, section number, section day and time, location, and course name.
 * @author Michael Zaragoza and Rifa Safeer Shah
 * @date 21 October 2019
 */

package cecs277DemoMementoPattern;

public class Memento {
	/** The name of the course */
	String courseName;
	/** The section number of this particular section */
	int sectionNumber;
	/** The name of the instructor*/
	String instructorName;
	/** The start time name */
	Time startTime;
	/** The end time name */
	Time endTime; 
	/** The day of the course section*/
	Time day;
	/** The Building where this section is held */
	String Building;
	/** The room number of this section */
	String Room;
	
	/** This includes course information */
	public Memento(String courseName, int sectionNumber, String instructorName, Time startTime, Time endTime, Time day, String building,
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
	
	public String getCourseName() {
		return courseName;
	} //ends courseName
	public int getSectionNumber() {
		return sectionNumber;
	} //ends sectionNumber
	public Time getStartTime() {
		return startTime;
	} //ends getStartTime
	public Time getEndTime() {
		return endTime;
	} //ends getEndTime
	public String getBuilding() {
		return Building;
	} //ends getBuilding
	public String getRoom() {
		return Room;
	} //ends getRoom
	public String getInstructorName() {
		return instructorName;
	} //ends getInstructorName
	public Time getDay() {
		return day;
	} //ends getDay
}
