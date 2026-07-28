import React from "react";
import officeImage from "./office.jpg";

function App() {

  const office = {
    name: "Smart Business Center",
    rent: 55000,
    address: "Madhapur, Hyderabad"
  };

  const officeList = [
    {
      id: 1,
      name: "Smart Business Center",
      rent: 55000,
      address: "Hyderabad"
    },
    {
      id: 2,
      name: "Tech Park",
      rent: 75000,
      address: "Bangalore"
    },
    {
      id: 3,
      name: "Innovation Hub",
      rent: 45000,
      address: "Chennai"
    }
  ];

  return (

    <div style={{ margin: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office Space"
        width="500"
        height="300"
      />

      <hr />

      <h2>Featured Office</h2>

      <h3>Name: {office.name}</h3>

      <h3
        style={{
          color: office.rent < 60000 ? "red" : "green"
        }}
      >
        Rent: ₹ {office.rent}
      </h3>

      <h3>Address: {office.address}</h3>

      <hr />

      <h2>Available Office Spaces</h2>

      {

        officeList.map((item) => (

          <div
            key={item.id}
            style={{
              border: "1px solid black",
              padding: "10px",
              marginBottom: "15px",
              width: "450px"
            }}
          >

            <h3>{item.name}</h3>

            <h4
              style={{
                color: item.rent < 60000 ? "red" : "green"
              }}
            >
              Rent: ₹ {item.rent}
            </h4>

            <h4>Address: {item.address}</h4>

          </div>

        ))

      }

    </div>

  );

}

export default App;