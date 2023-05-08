// StudentRecordEdit.js
import { LightningElement, track, api } from 'lwc';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';
import updateStudentRecord from '@salesforce/apex/StudentRecordController.updateStudentRecord';

export default class StudentRecordEdit extends LightningElement {
  @api studentRecordId;
  @track studentName;
  @track studentId;
  @track studentGrade;

  // Get the student record fields when the component is loaded
  connectedCallback() {
    this.getStudentRecordFields();
  }
  
  // Retrieve the student record fields and set the component fields with the Student record data
  getStudentRecordFields() {
    getStudentRecord({studentRecordId: this.studentRecordId})
        .then(result => {
            this.studentName = result.Name;
            this.studentId = result.Id;
            this.studentGrade = result.Grade;
        })
        .catch(error => {
            this.dispatchEvent(
                new ShowToastEvent({
                    title: 'Error loading Student Record',
                    message: error.message,
                    variant: 'error',
                }),
            );
        });
  }

  // Handle changes to the student record fields
  handleChange(event) {
      this[event.target.name] = event.target.value;
  }

  // Save the student record
  saveStudentRecord() {
    updateStudentRecord({
        studentRecordId: this.studentRecordId,
        studentName: this.studentName,
        studentId: this.studentId,
        studentGrade: this.studentGrade
    })
    .then(() => {
        this.dispatchEvent(
            new ShowToastEvent({
                title: 'Success',
                message: 'Student record updated',
                variant: 'success'
            })
        );
    })
    .catch(error => {
        this.dispatchEvent(
            new ShowToastEvent({
                title: 'Error saving Student Record',
                message: error.message,
                variant: 'error',
            }),
        );
    });
  }

}