import { Injectable } from '@angular/core';

import { Actions, createEffect, ofType } from '@ngrx/effects';

import * as CourseActions from './course.actions';

import { CourseService } from '../../services/course';

import { catchError, map, switchMap } from 'rxjs/operators';



import { of } from 'rxjs';

@Injectable()
export class CourseEffects {

  constructor(

    private actions$: Actions,

    private courseService: CourseService

  ) {}

  loadCourses$ = createEffect(() =>

    this.actions$.pipe(

      ofType(CourseActions.loadCourses),

      switchMap(() =>

        this.courseService.getCourses().pipe(

          map(courses =>

            CourseActions.loadCoursesSuccess({ courses })

          ),

          catchError(error =>

            of(

              CourseActions.loadCoursesFailure({

                error: error.message

              })

            )

          )

        )

      )

    )

  );

}