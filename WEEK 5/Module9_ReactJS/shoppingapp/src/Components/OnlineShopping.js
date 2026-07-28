import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {

    constructor(props) {

        super(props);

        this.items = [

            { itemName: "Laptop", price: 65000 },

            { itemName: "Mobile", price: 25000 },

            { itemName: "Headphones", price: 3000 },

            { itemName: "Smart Watch", price: 5000 },

            { itemName: "Keyboard", price: 1500 }

        ];

    }

    render() {

        return (

            <div>

                <h1>Online Shopping Cart</h1>

                <table border="1" cellPadding="10">

                    <thead>

                        <tr>

                            <th>Item Name</th>

                            <th>Price</th>

                        </tr>

                    </thead>

                    <tbody>

                        {

                            this.items.map((item, index) => (

                                <Cart

                                    key={index}

                                    itemName={item.itemName}

                                    price={item.price}

                                />

                            ))

                        }

                    </tbody>

                </table>

            </div>

        );

    }

}

export default OnlineShopping;