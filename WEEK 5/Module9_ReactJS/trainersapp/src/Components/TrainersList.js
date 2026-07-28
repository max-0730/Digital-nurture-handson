import React from "react";
import trainers from "../TrainersMock";
import { Link } from "react-router-dom";

function TrainersList() {

    return (

        <div>

            <h2>Trainer List</h2>

            <ul>

                {

                    trainers.map((trainer) => (

                        <li key={trainer.id}>

                            <Link to={`/trainers/${trainer.id}`}>
                                {trainer.name}
                            </Link>

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default TrainersList;