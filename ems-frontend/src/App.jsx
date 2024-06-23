import './App.css'
import ListEmployeeComponent from './Components/ListEmployeeComponent'
import Header from './Components/Header'
import Footer from './Components/Footer'
import { BrowserRouter,Route,Routes } from 'react-router-dom'
import Employee from './Components/Employee'

function App() {

  return (
    <>
      <BrowserRouter>
        <Header />
          <Routes>
            <Route path='/' element={<ListEmployeeComponent />}></Route>
            <Route path='/employees' element={<ListEmployeeComponent />}></Route>
            <Route path='/add-employee' element={<Employee />}></Route>
            <Route path='/edit-employee/:id' element={<Employee />}></Route>
          </Routes>
        <Footer />
      </BrowserRouter>
    </>
  )
}

export default App
