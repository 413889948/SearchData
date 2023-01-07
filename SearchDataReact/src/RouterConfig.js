import React from 'react';
import {Router,Route,Switch,Redirect} from 'react-router-dom';
import { createHashHistory } from "history";
import {Test} from "./test/test";
const history = createHashHistory();

class RouterConfig extends React.Component{
    render(){
        return(
            <Router history={history} >
                <Switch >
                    <Route path='/' exact render={()=>(
                        <Redirect to='/Page1'/>
                    )}/>
                    <Route path='/Page1' component={Test}/>
                    <Route path='/Page2' component={Test}/>
                </Switch>
            </Router>
        )
    }
}
export default RouterConfig;