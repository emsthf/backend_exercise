import { Route, Routes } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Add_product_form from './components/pages/Add_product_form';
import Add_user_form from './components/pages/Add_user_form';
import Home from './components/pages/Home';
import Product_table from './components/pages/Product_table';
import User_table from './components/pages/User_table';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/addUserForm" element={<Add_user_form />} />
        <Route path="/userTable" element={<User_table />} />
        <Route path="/addProductForm" element={<Add_product_form />} />
        <Route path="/productTable" element={<Product_table />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
