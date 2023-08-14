import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Axios from "../../apis/Axios";

const Prijava = (props) => {

    const takmicar = {
        takmicenjeId: props.takmicenje,
        drzava: '',
        email: ''

    }
   
    const [prijava, setPrijava] = useState(takmicar)
    var navigate = useNavigate()


    const prijaviSe = () => {

        const dto = {
            takmicenjeId: props.takmicenje,
            drzava: prijava.drzava.toUpperCase(),
            email: prijava.email
        }

        Axios.post('/prijava', dto)
            .then(res => {
                console.log(res)
                navigate('/takmicenja')
            })
            .catch(err => {
                console.log(err)
                alert("Doslo je do greske, pokusajte novi unos!")
            })
    }

    const valueInputChanged = (e) => {

        let input = e.target;
        let name = input.name;
        let value = input.value;

        prijava[name] = value;
        setPrijava(prijava);
    }
    console.log(takmicar)
    return(
        <div>
            <Col>
          <br/><br/>
          <Row><h1>Prijava na takmicenje</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
              <Form>
                <Form.Label htmlFor="drzava">Drzava</Form.Label>
                <Form.Control id="drzava" placeholder="(USA)" type="text" name="drzava" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="email">Emal</Form.Label>
                <Form.Control id="email" name="email" placeholder="email@email.com" type="email" onChange={(e) => valueInputChanged(e)}/>
                <br/>
                <Button className="btn btn-success" onClick={() => prijaviSe()}>Prijavi se</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>
    );


}

export default Prijava;