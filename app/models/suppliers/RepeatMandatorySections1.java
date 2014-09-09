package models.suppliers;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class RepeatMandatorySections1 extends Model{
	
	
	@Id
	public Long id;
	
	public String isRelatedSelection;
	public String multipleSelectionAnswerChoice1;
	public String multipleSelectionAnswerChoice2;
	public String multipleSelectionAnswerChoice3;
	public String multipleSelectionAnswerChoice4;
	public String radioSelectionAnswerOptionYes;
	public String radioSelectionAnswerOptionNo;
	public String relatedSelectionInfo;


}
