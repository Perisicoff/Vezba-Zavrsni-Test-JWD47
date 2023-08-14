import React, { useCallback, useEffect, useState } from 'react'
import { Button, Col, Collapse, Form, Row, Table } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import Axios from '../../apis/Axios';
import {IsLoggedIn} from '../../service/auth'
import '../../index.css'
import { Rola } from '../../service/auth'

const Takmicenja = (props) => {

    var navigate = useNavigate()
    const [takmicenja, setTakmicenja] = useState([])
    const [formati, setFormati] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPage, setTotalPage] = useState(0)
    const [isChecked, setIsChecked] = useState(false);
    const [searchParams, setSearchParams] = useState({
      mestoOdrzavanja: "",
      formatId: ""
    })

    const getAll = useCallback((nextPage) => {
        const config = {
          params: {
            mestoOdrzavanja: searchParams.mestoOdrzavanja,
            formatId: searchParams.formatId,
            pageNo: nextPage
          }
        }
        Axios.get('/takmicenja', config)
        .then(res => {
          console.log(res)
          setTakmicenja(res.data)
          setPageNo(nextPage)
          setTotalPage(res.headers["total-pages"])
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

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
      getAll(pageNo)
      getAll2()
    }, [])

    const goToAdd = () => {
      navigate('/takmicenje/add')
    }

    const prijava = (takmicenjeId) => {
        navigate('/prijava/add')
        props.callBackF(takmicenjeId)
      }

    const delte = (takmicenjeId) => {
      const confirmDelete = window.confirm("Da li ste sigurni da zelite da obrisete ovo takmicenje?");
      if (confirmDelete) {
        Axios.delete('/takmicenja/' + takmicenjeId)
        .then(res => {
          console.log(res)
          setTakmicenja((takmicenja)=>takmicenja.filter(takmicenje => takmicenje.id !== takmicenjeId))
        })
        .catch(err => {
          console.log(err)
        })
      } else {
        navigate('/takmicenja')
      }
    }

    const rednerAll = () => {
      return takmicenja.map((takmicenje) => {
        return(
          <tr key={takmicenje.id}>
            <td>{takmicenje.naziv}</td>
            <td>{takmicenje.mestoOdrzavanja}</td>
            <td>{takmicenje.datumPocetka}</td>
            <td>{takmicenje.datumZavrsetka}</td>
            <td>{takmicenje.nazivFormata}</td>
            {IsLoggedIn() && Rola() == "korisnik" && takmicenje.brojUcesnika > 0 && <td><Button className="btn btn-info" onClick={() => prijava(takmicenje.id)}>Prijavi se</Button></td>}
            {IsLoggedIn() && Rola() == "admin" && <td><Button className="btn btn-danger" onClick={() => delte(takmicenje.id)}>Ukloni</Button></td>}
          </tr>
        )
      })

    }

    const rednerAll2 = () => {
      return formati.map((format) => {
        return(<option key={format.id} value={format.id}>{format.tip}</option>)
      })

    }

    const serchValue = (event) => {
      let name = event.target.name
      let value = event.target.value
      
      searchParams[name] = value
      setSearchParams(searchParams)
      getAll(0)
    }
    
    return (
      <div>
        <Row className="justify-content-center">
        <Col>
          <br/><br/>
          <Row><h1>Takmicenja</h1></Row>
            <Form.Group style={{marginTop:35}}>
                <Form.Check type="checkbox" label="Show search form" onClick={(event) => setIsChecked(event.target.checked)}/>
            </Form.Group>
            <Collapse in={isChecked}>
            <Form style={{marginTop:10}}>
                <Form.Group>
                    <Form.Label>Format takmicenja</Form.Label>
                    <Form.Select name='formatId' onChange={serchValue}>
                        <option value={""}>--izaberi format--</option>
                        {rednerAll2()}
                    </Form.Select>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Mesto Odrzavanja</Form.Label>
                    <Form.Control type='text' name='mestoOdrzavanja' onChange={serchValue} ></Form.Control><br/>
                </Form.Group>
            </Form>
            </Collapse>
          <Row>
            <Col>
              <Table>
                <thead>
                  <tr>
                    <th>Naziv takmicenja</th>
                    <th>Mesto odrzavanja</th>
                    <th>Datum pocetka takmicenja</th>
                    <th>Datum zavrsetka takmicenja</th>
                    <th>Format</th>
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  {rednerAll()}
                </tbody>
              </Table>
            </Col>
          </Row>
          {IsLoggedIn() && Rola() == "admin" && <Button className="btn btn-success" onClick={() => goToAdd()}>Kreiraj takmicenje</Button>}
          <br/>
          <div style={{ display: 'flex', justifyContent: 'center' }}>
            <Button className="btn btn-light btn-sm" disabled={pageNo==0} onClick={() => getAll(pageNo-1)}>{'❮'}</Button>
            <span style={{ margin: '10px' }}> {pageNo + 1} </span> 
           <Button className="btn btn-light btn-sm" disabled={pageNo==totalPage-1 || takmicenja.length === 0} onClick={() => getAll(pageNo+1)}>{'❯'}</Button>
          </div>
        </Col>
        </Row>
      </div>
    );
  }

export default Takmicenja;