import React from "react";
import CohortDetails from "./Components/CohortDetails";

function App() {

    return (

        <div>

            <h1>Cognizant Academy Dashboard</h1>

            <CohortDetails
                cohortName="ReactJS"
                status="Ongoing"
                coach="John"
                trainer="David"
            />

            <CohortDetails
                cohortName="Java FSE"
                status="Completed"
                coach="Ravi"
                trainer="Anand"
            />

            <CohortDetails
                cohortName="Spring Boot"
                status="Ongoing"
                coach="Smith"
                trainer="Kiran"
            />

        </div>

    );

}

export default App;