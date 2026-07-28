import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment.html',
  styleUrl: './reactive-enrollment.css'
})
export class ReactiveEnrollmentComponent {

  enrollForm: FormGroup;

  submitted = false;

  constructor(private fb: FormBuilder) {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [Validators.required, Validators.minLength(3)]
      ],

      studentEmail: this.fb.control(
        '',
        [Validators.required, Validators.email],
        [this.simulateEmailCheck]
      ),

      courseId: [
        '',
        [Validators.required, this.noCourseCode]
      ],

      preferredSemester: [
        '',
        Validators.required
      ],

      additionalCourses: this.fb.array([])

    });

  }

  // Custom Validator
  noCourseCode(control: AbstractControl): ValidationErrors | null {

    const value = control.value;

    if (value && value.toString().startsWith('XX')) {

      return {
        noCourseCode: true
      };

    }

    return null;

  }

  // Async Validator
  simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {

    return new Promise(resolve => {

      setTimeout(() => {

        if (control.value && control.value.includes('test@')) {

          resolve({
            emailTaken: true
          });

        } else {

          resolve(null);

        }

      }, 800);

    });

  }

  // FormArray Getter
 get additionalCourses(): FormArray<FormControl> {

  return this.enrollForm.get('additionalCourses') as FormArray<FormControl>;

}
  addCourse() {

    this.additionalCourses.push(
    new FormControl<string>('', {
        nonNullable: true,
        validators: Validators.required
    })
);

  }

  removeCourse(index: number) {

    this.additionalCourses.removeAt(index);

  }

  onSubmit() {

    console.log(this.enrollForm.value);

    console.log(this.enrollForm.valid);

    this.submitted = true;

  }

}