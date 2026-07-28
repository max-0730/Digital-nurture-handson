import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { HighlightDirective } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';


import { Course } from '../../models/course.model';

import { Store } from '@ngrx/store';

import {
  enrollInCourse,
  unenrollFromCourse
} from '../../store/enrollment/enrollment.actions';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [
    CommonModule,
    HighlightDirective,
    CreditLabelPipe
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {

  @Input() course!: Course;

  @Output()
  enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  constructor(
  private store: Store
) {}

enroll() {

  this.store.dispatch(

    enrollInCourse({

      courseId: this.course.id

    })

  );

}

unenroll() {

  this.store.dispatch(

    unenrollFromCourse({

      courseId: this.course.id

    })

  );

}


  ngOnChanges(changes: SimpleChanges): void {

    console.log(
      'Course changed:',
      changes['course']?.previousValue,
      changes['course']?.currentValue
    );

  }

  

  

  toggleDetails(): void {

    this.isExpanded = !this.isExpanded;

  }

 get cardClasses() {

  return {

    'card--full': this.course.credits >= 4,

    'expanded': this.isExpanded

  };

}

  getBorderColor(): string {

    switch (this.course.gradeStatus) {

      case 'passed':
        return 'green';

      case 'failed':
        return 'red';

      default:
        return 'gray';

    }

  }

}