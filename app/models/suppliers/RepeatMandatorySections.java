package models.suppliers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;


@Entity
public class RepeatMandatorySections extends Model{
	
	@Id
	public Long id;
	
	public String additionalMandatoryServiceName;
	public String additionalMandatoryServiceValidityFrom;
	public String additionalMandatoryServiceValidityTo;
	public String additionalMandatoryServiceIsApply;
	public String additionalMandatoryServiceisCheckin;
	public String additionalMandatoryServicePerRoomRate;
	public String additionalMandatoryServicePerPersonAdultRate;
	public String additionalMandatoryServicePerPersonChildRate;
	public String isRelatedInfo;
	public String isRelatedSelection;
	public String relatedSelectionInfo;
	public String multipleSelectionAnswerChoice1;
	public String multipleSelectionAnswerChoice2;
	public String multipleSelectionAnswerChoice3;
	public String multipleSelectionAnswerChoice4;
	public String radioSelectionAnswerOptionYes;
	public String radioSelectionAnswerOptionNo;

	@OneToMany(cascade={CascadeType.ALL})
	public List<RepeatMandatorySections1> repeatMandatorySections1s;

}
