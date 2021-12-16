import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Signup from './componets/pages/Sign_up';
import Table1 from './componets/pages/Table1';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Signup />} />
        <Route path="/list" element={<Table1 />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
