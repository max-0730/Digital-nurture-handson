import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { CourseService } from '../../../services/course';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentFormComponent {

  studentName = '';
  studentEmail = '';
  courseId: number | null = null;
  preferredSemester = '';
  agreeToTerms = false;

  submitted = false;
  constructor(private courseService: CourseService) {}

  onSubmit(form: NgForm) {

  console.log('Form Value:', form.value);
  console.log('Form Valid:', form.valid);

  if (form.valid) {

    const newCourse = {

      name: this.studentName,
      code: 'NEW101',
      credits: 3,
      gradeStatus: 'pending' as const

    };

    this.courseService.addCourse(newCourse).subscribe({

      next: (course) => {

        console.log('Course Added Successfully:', course);

        this.submitted = true;

        form.resetForm();

      },

      error: (err) => {

        console.error('Error:', err);

      }

    });

  }

}

}