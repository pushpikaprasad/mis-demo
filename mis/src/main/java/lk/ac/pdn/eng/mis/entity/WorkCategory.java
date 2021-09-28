package lk.ac.pdn.eng.mis.entity;

public class WorkCategory {
	
	int workCategoryID;
	String workCategoryHTML;
	
	public int getWorkCategoryID() {
		return workCategoryID;
	}
	public void setWorkCategoryID(int workCategoryID) {
		this.workCategoryID = workCategoryID;
	}
	public String getWorkCategoryHTML(int id) {
		if(id == 1) {
			this.workCategoryHTML = "<div id=\"view_applications\" class=\"col s12 m12 l4 \">\r\n"
					+ "				<div class=\"card cardHover #b9f6ca green accent-1 hoverable\">\r\n"
					+ "					<a href=\"/officerDashboard/Applications\"\r\n"
					+ "						class=\"btn_load_student black-text\">\r\n"
					+ "						<div class=\"card-content  waves-effect waves-block waves-light\">\r\n"
					+ "							<span class=\"card-title activator text-darken-4\"><b>NEW APPLICATIONS</b><i class=\"material-icons left\"\r\nstyle=\"font-size: 40px; padding:12px;\">note_add</i></span>\r\n"
					+ "								<p>NEW/COMPLETED APPLICATIONS</p>\r\n"
					+ "							\r\n"
					+ "						</div>\r\n"
					+ "					</a>\r\n"
					+ "				</div>\r\n"
					+ "			</div>";
		}else if(id == 2) {
			this.workCategoryHTML = "<div id=\"accepted_transcript_academic_applications\" class=\"col s12 m12 l4\">\r\n"
					+ "				<div class=\"card cardHover #81d4fa light-blue lighten-3 hoverable\">\r\n"
					+ "					<a href=\"/officerDashboard/accepted_transcript_academic_applications\"\r\n"
					+ "						class=\"btn_load_student black-text\">\r\n"
					+ "						<div class=\"card-content  waves-effect waves-block waves-light\">\r\n"
					+ "							<span class=\"card-title activator text-darken-4\"><b>APPLICATION PROCESS</b><i class=\"material-icons left\"\r\nstyle=\"font-size: 40px; padding:12px;\">file_copy</i></span>\r\n"
					+ "								<p>TRANSCRIPT/ACADEMIC RANK APPLICATIONS</p>\r\n"
					+ "							\r\n"
					+ "						</div>\r\n"
					+ "					</a>\r\n"
					+ "				</div>\r\n"
					+ "			</div>";
		}else if(id == 3) {
			this.workCategoryHTML = "<div id=\"accepted_transcript_academic_applications\" class=\"col s12 m12 l4 \">\r\n"
					+ "				<div class=\"card cardHover #bcaaa4 brown lighten-3 hoverable\">\r\n"
					+ "					<a href=\"/officerDashboard/Check_transcript_academic_documents\"\r\n"
					+ "						class=\"btn_load_student black-text\">\r\n"
					+ "						<div class=\"card-content  waves-effect waves-block waves-light\">\r\n"
					+ "							<span class=\"card-title activator text-darken-4\"><b>CHECK APPLICATIONS</b><i class=\"material-icons left\"\r\n"
					+ "								style=\"font-size: 40px; padding:12px;\">task</i></span>\r\n"
					+ "								<p>TRANSCRIPT/ACADEMIC RANK DOCUMENTS</p>\r\n"
					+ "							\r\n"
					+ "						</div>\r\n"
					+ "					</a>\r\n"
					+ "				</div>\r\n"
					+ "			</div>";
		}else {
			workCategoryHTML = "";
		}
		
		return this.workCategoryHTML;
	}
	public void setWorkCategoryHTML(String workCategoryHTML) {
		this.workCategoryHTML = workCategoryHTML;
	}
	

}
