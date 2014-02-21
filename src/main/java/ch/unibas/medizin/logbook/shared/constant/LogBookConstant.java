package ch.unibas.medizin.logbook.shared.constant;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class LogBookConstant {
	public static int TABLE_PAGE_SIZE = 5;
	public static final int TABLE_JUMP_SIZE = 5;
	public static final int SPLIT_PANEL_MINWIDTH = 520;
	public static final int ENTRY_TIMEOUT_MS = 700;

	// Constants moved from I18N-properties files.
	public static final int WIDTH_SIZE = 1225;
	public static final int WIDTH_MIN = 705;
	public static final int ANIMATION_TIME = 3000;

	public static String BLANK_FIELD_MESSAGE = "Please enter details for";

	public static String NEW_STATUS = "Osce_New_Status";
	public static String BluePrint_Status = "Osce_BluePrint_Status";
	public static String Genrated_Status = "Osce_Genrated_Status";
	public static String Fixed_Status = "Osce_Fixed_Status";
	public static String Closed_Status = "Osce_Closed_Status";

	public static int OSCECOOKIEDAY = 0;
	public static int OSCEDAYTIMESCHEDULE = 600000;

	public static final SafeHtml FLAG_ICON = new SafeHtmlBuilder().appendHtmlConstant("<span class=\"ui-icon ui-icon-flag\"></span>").toSafeHtml();
	public static final SafeHtml COMMENT_ICON = new SafeHtmlBuilder().appendHtmlConstant("<span class=\"ui-icon ui-icon-comment\"></span>").toSafeHtml();
	public static final SafeHtml SEARCH_ICON = new SafeHtmlBuilder().appendHtmlConstant("<span class=\"ui-icon ui-icon-search\"></span>").toSafeHtml();
	public static final SafeHtml WRENCH_ICON = new SafeHtmlBuilder().appendHtmlConstant("<span class=\"ui-icon ui-icon-wrench\"></span>").toSafeHtml();

	public static final SafeHtml COLOR_PICKER_ICON = new SafeHtmlBuilder().appendHtmlConstant("<span class=\"ui-icon ui-icon-triangle-1-s\"></span>").toSafeHtml();
	public static final String UNIQUE_ID = "uniqueID";
	public static final String CURRENT_USER = "currentUser";
	public static final String STUDENT = "student";
	public static final String ADMIN = "admin";

	// Total Skill Acquired Display in Home Tab Skill Acquired Table
	public static final int TOTAL_SKILL_ACQUIRED_DISPLAY = 20;
	public static final long ERROR_MESSAGE_TIME = 5000;
}
