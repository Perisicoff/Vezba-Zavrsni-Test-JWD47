import { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Axios from "../../apis/Axios";

const NovoTakmicenje = () => {

    const takmicenje = {
        id: -1,
        naziv: '',
        mestoOdrzavanja: '',
        datumPocetka: 0,
        datumZavrsetka: 0,
        formatId: -1

    }
    const [formati, setFormati] = useState([])
    const [novoTakmicenje, setNovoTakmicenje] = useState(takmicenje)
    var navigate = useNavigate()


    const dodaj = () => {

        const dto = {
            naziv: novoTakmicenje.naziv,
            mestoOdrzavanja: novoTakmicenje.mestoOdrzavanja,
            datumPocetka: novoTakmicenje.datumPocetka,
            datumZavrsetka: novoTakmicenje.datumZavrsetka,
            formatId: novoTakmicenje.formatId
        }

        Axios.post('/takmicenja', dto)
            .then(res => {
                console.log(res)
                navigate('/takmicenja')
            })
            .catch(err => {
                console.log(err)
                alert("Doslo je do greske, pokusajte novi unos!")
            })
    }

    const getAll2 = useCallback(() => {
        Axios.get('/formati')
        .then(res => {
          console.log(res)
          setFormati(res.data)
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    useEffect(() => {
        getAll2()
      }, [])

    const valueInputChanged = (e) => {

        let input = e.target;
        let name = input.name;
        let value = input.value;

        novoTakmicenje[name] = value;
        setNovoTakmicenje(novoTakmicenje);
    }

    const rednerAll2 = () => {
        return formati.map((format) => {
        return(<option key={format.id} value={format.id}>{format.tip}</option>)
        })

    }

    return(
        <div>
            <Col>
          <br/><br/>
          <Row><h1>Kreiraj takmicenje</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
              <Form>
                <Form.Label htmlFor="naziv">Naziv takmicenja</Form.Label>
                <Form.Control id="naziv" placeholder="naziv takmicenja" type="text" name="naziv" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="mestoOdrzavanja">Mesto Odrzavanja</Form.Label>
                <Form.Control id="mestoOdrzavanja" name="mestoOdrzavanja" placeholder="mesto odrzavanja" type="text" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="datumPocetka">Datum Pocetka</Form.Label>
                <Form.Control id="datumPocetka" name="datumPocetka" type="date" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="datumZavrsetka">Datum Pocetka</Form.Label>
                <Form.Control id="datumZavrsetka" name="datumZavrsetka" type="date" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="formatId">Formati</Form.Label>
                <Form.Select name='formatId' onChange={(e) => valueInputChanged(e)}>
                        <option value={""}>--izaberi format--</option>
                        {rednerAll2()}
                    </Form.Select>
                <br/>
                <Button className="btn btn-success" onClick={() => dodaj()}>Kreiraj takmicenje</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>
    );


}

export default NovoTakmicenje;