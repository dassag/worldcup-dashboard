import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {GiTrophyCup} from "react-icons/gi";
import { Link } from 'react-router-dom';


function NavbarLocal() {
  return (
    <>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand><Link to={'/'}><GiTrophyCup size='30px'/></Link></Navbar.Brand>
          <Nav className="me-auto">
            <Link to ={'/countries'}>Countries</Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default NavbarLocal;