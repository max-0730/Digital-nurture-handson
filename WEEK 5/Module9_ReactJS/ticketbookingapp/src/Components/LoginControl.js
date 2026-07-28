import React,{Component} from "react";

import Guest from "./Guest";

import User from "./User";

class LoginControl extends Component{

constructor(){

super();

this.state={

isLoggedIn:false

};

}

login=()=>{

this.setState({

isLoggedIn:true

});

}

logout=()=>{

this.setState({

isLoggedIn:false

});

}

render(){

return(

<div>

{

this.state.isLoggedIn?

<User/>:<Guest/>

}

<br/>

{

this.state.isLoggedIn?

<button onClick={this.logout}>

Logout

</button>

:

<button onClick={this.login}>

Login

</button>

}

</div>

);

}

}

export default LoginControl;