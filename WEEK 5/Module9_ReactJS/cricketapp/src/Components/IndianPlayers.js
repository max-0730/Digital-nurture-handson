import React from "react";

function IndianPlayers() {

    const team = [

        "Virat",
        "Rohit",
        "Gill",
        "Rahul",
        "Hardik",
        "Jadeja"

    ];

    const oddPlayers = team.filter((player, index) => index % 2 === 0);

    const evenPlayers = team.filter((player, index) => index % 2 !== 0);

    const T20Players = [

        "Surya",
        "Rinku",
        "Tilak"

    ];

    const RanjiPlayers = [

        "Pujara",
        "Rahane",
        "Sarfaraz"

    ];

    const mergedPlayers = [

        ...T20Players,
        ...RanjiPlayers

    ];

    return (

        <div>

            <h2>Odd Team Players</h2>

            <ul>

                {

                    oddPlayers.map((player,index)=>

                        <li key={index}>{player}</li>

                    )

                }

            </ul>

            <h2>Even Team Players</h2>

            <ul>

                {

                    evenPlayers.map((player,index)=>

                        <li key={index}>{player}</li>

                    )

                }

            </ul>

            <h2>Merged Players</h2>

            <ul>

                {

                    mergedPlayers.map((player,index)=>

                        <li key={index}>{player}</li>

                    )

                }

            </ul>

        </div>

    );

}

export default IndianPlayers;