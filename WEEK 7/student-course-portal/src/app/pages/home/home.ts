import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CourseService } from '../../services/course';
import { CourseSummaryWidgetComponent } from '../../components/course-summary-widget/course-summary-widget';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CourseSummaryWidgetComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  portalName = 'Student Course Portal';

  coursesAvailable = 0;

  // From previous hands-ons
  isPortalActive = true;
  message = '';
  searchTerm = '';

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {

  this.courseService.getCourses().subscribe({

    next: (courses) => {

      this.coursesAvailable = courses.length;

    }

  });

}

  onEnrollClick(): void {

    this.message = 'Enrollment Successful!';

  }

  addDummyCourse() {

  this.courseService.addCourse({

    name: 'Python',

    code: 'PY101',

    credits: 3,

    gradeStatus: 'pending'

  }).subscribe({

    next: () => {

      this.courseService.getCourses().subscribe({

        next: (courses) => {

          this.coursesAvailable = courses.length;

        }

      });

    }

  });

}

}