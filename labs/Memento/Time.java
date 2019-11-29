/**
 * The Time class includes the enum of times and days.
 * @author Michael Zaragoza and Rifa Safeer Shah
 * @date 21 October 2019
 */

package cecs277DemoMementoPattern;
public enum Time {
	EIGHT,
	EIGHT_THIRTY,
	NINE,
	NINE_THIRTY,
	TEN,
	TEN_THIRTY,
	ELEVEN,
	ELEVEN_THIRTY,
	NOON,
	TWELVE_THIRTY,
	ONE,
	ONE_THIRTY,
	TWO,
	TWO_THIRTY,
	THREE,
	THREE_THIRTY,
	FOUR,
	FOUR_THIRTY,
	FIVE,
	FIVE_THIRTY,
	SIX,
	MONDAY_WEDNESDAY,
	TUESDAY_THURSDAY,
	FRIDAY,
	SATURDAY;
	
	public String to_string () {
		return this.name().toLowerCase().replace("_", " ");
		}
	}
