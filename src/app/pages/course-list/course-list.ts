import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Observable } from 'rxjs';
import { Store } from '@ngrx/store';

import { Course } from '../../models/course.model';
import { CourseCardComponent } from '../../components/course-card/course-card';

import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses } from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CourseCardComponent
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {

  courses$: Observable<Course[]>;

  selectedCourseId = 0;

  searchTerm = '';

  constructor(

    private store: Store,

    private router: Router,

    private route: ActivatedRoute

  ) {

    this.courses$ = this.store.select(selectAllCourses);

  }

  ngOnInit(): void {

    this.store.dispatch(loadCourses());

    this.searchTerm =
      this.route.snapshot.queryParamMap.get('search') || '';

  }

  searchCourses(): void {

    this.router.navigate(
      ['courses'],
      {
        queryParams: {
          search: this.searchTerm
        }
      }
    );

  }

  viewCourse(courseId: number): void {

    this.router.navigate(['courses', courseId]);

  }

  onEnroll(courseId: number): void {

    this.selectedCourseId = courseId;

  }

  trackByCourseId(index: number, course: Course): number {

    return course.id;

  }

}