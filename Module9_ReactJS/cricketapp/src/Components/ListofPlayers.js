import React from "react";

function ListofPlayers() {

    const players = [

        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 82 },
        { name: "KL Rahul", score: 65 },
        { name: "Shubman Gill", score: 76 },
        { name: "Hardik Pandya", score: 55 },
        { name: "Ravindra Jadeja", score: 72 },
        { name: "Rishabh Pant", score: 60 },
        { name: "Mohammed Shami", score: 25 },
        { name: "Jasprit Bumrah", score: 15 },
        { name: "Kuldeep Yadav", score: 40 },
        { name: "Mohammed Siraj", score: 35 }

    ];

    return (

        <div>

            <h2>List of Players</h2>

            <table border="1" cellPadding="8">

                <thead>

                    <tr>

                        <th>Player</th>

                        <th>Score</th>

                    </tr>

                </thead>

                <tbody>

                    {

                        players.map((player, index) => (

                            <tr key={index}>

                                <td>{player.name}</td>

                                <td>{player.score}</td>

                            </tr>

                        ))

                    }

                </tbody>

            </table>

            <br/>

            <h2>Players with Score Below 70</h2>

            <ul>

                {

                    players

                        .filter(player => player.score < 70)

                        .map((player, index) => (

                            <li key={index}>

                                {player.name} - {player.score}

                            </li>

                        ))

                }

            </ul>

        </div>

    );

}

export default ListofPlayers;