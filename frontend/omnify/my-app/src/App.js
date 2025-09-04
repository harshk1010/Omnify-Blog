// // // // import logo from './logo.svg';
// // // // import './App.css';

// // // // function App() {
// // // //   return (
// // // //     <div className="App">
// // // //       <header className="App-header">
// // // //         <img src={logo} className="App-logo" alt="logo" />
// // // //         <p>
// // // //           Edit <code>src/App.js</code> and save to reload.
// // // //         </p>
// // // //         <a
// // // //           className="App-link"
// // // //           href="https://reactjs.org"
// // // //           target="_blank"
// // // //           rel="noopener noreferrer"
// // // //         >
// // // //           Learn React
// // // //         </a>
// // // //       </header>
// // // //     </div>
// // // //   );
// // // // }

// // // // export default App;

// // // import React, { useState } from "react";
// // // import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
// // // import Login from "./pages/Login";
// // // import Signup from "./pages/Signup";

// // // function App() {
// // //   const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("token"));

// // //   const handleLogin = () => {
// // //     localStorage.setItem("token", "demoToken123"); // fake token
// // //     setIsLoggedIn(true);
// // //   };

// // //   const handleLogout = () => {
// // //     localStorage.removeItem("token");
// // //     setIsLoggedIn(false);
// // //   };

// // //   return (
// // //     <Router>
// // //       <Routes>
// // //         {/* Login route */}
// // //         <Route
// // //           path="/login"
// // //           element={
// // //             isLoggedIn ? (
// // //               <Navigate to="/" />
// // //             ) : (
// // //               <Login onLogin={handleLogin} />
// // //             )
// // //           }
// // //         />

// // //         {/* Signup route */}
// // //         <Route
// // //           path="/signup"
// // //           element={
// // //             isLoggedIn ? (
// // //               <Navigate to="/" />
// // //             ) : (
// // //               <Signup onSignup={handleLogin} />
// // //             )
// // //           }
// // //         />

// // //         {/* Home route */}
// // //         <Route
// // //           path="/"
// // //           element={
// // //             isLoggedIn ? (
// // //               <div className="flex flex-col items-center justify-center h-screen bg-gradient-to-r from-purple-400 via-pink-500 to-red-500 text-white">
// // //                 <h1 className="text-4xl font-bold mb-4">Welcome 🎉</h1>
// // //                 <button
// // //                   onClick={handleLogout}
// // //                   className="bg-white text-purple-600 px-6 py-2 rounded-lg shadow hover:bg-gray-200 transition"
// // //                 >
// // //                   Logout
// // //                 </button>
// // //               </div>
// // //             ) : (
// // //               <Navigate to="/login" />
// // //             )
// // //           }
// // //         />

// // //         {/* Catch all → redirect */}
// // //         <Route path="*" element={<Navigate to="/" />} />
// // //       </Routes>
// // //     </Router>
// // //   );
// // // }

// // // export default App;

// // import React, { useState } from "react";
// // import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
// // import Login from "./pages/Login";
// // import Signup from "./pages/Signup";

// // function App() {
// //   const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("token"));

// //   const handleLogin = () => {
// //     localStorage.setItem("token", "demoToken123"); // fake token
// //     setIsLoggedIn(true);
// //   };

// //   const handleLogout = () => {
// //     localStorage.removeItem("token");
// //     setIsLoggedIn(false);
// //   };

// //   return (
// //     <Router>
// //       <Routes>
// //         {/* Home route */}
// //         <Route
// //           path="/"
// //           element={
// //             isLoggedIn ? (
// //               <div className="flex flex-col items-center justify-center h-screen bg-gradient-to-r from-purple-400 via-pink-500 to-red-500 text-white">
// //                 <h1 className="text-4xl font-bold mb-4">Welcome 🎉</h1>
// //                 <button
// //                   onClick={handleLogout}
// //                   className="bg-white text-purple-600 px-6 py-2 rounded-lg shadow hover:bg-gray-200 transition"
// //                 >
// //                   Logout
// //                 </button>
// //               </div>
// //             ) : (
// //               <Navigate to="/login" replace />
// //             )
// //           }
// //         />

// //         {/* Login route */}
// //         <Route
// //           path="/login"
// //           element={
// //             isLoggedIn ? <Navigate to="/" replace /> : <Login onLogin={handleLogin} />
// //           }
// //         />

// //         {/* Signup route */}
// //         <Route
// //           path="/signup"
// //           element={
// //             isLoggedIn ? <Navigate to="/" replace /> : <Signup onSignup={handleLogin} />
// //           }
// //         />

// //         {/* Catch-all route → redirect to home */}
// //         <Route path="*" element={<Navigate to="/" replace />} />
// //       </Routes>
// //     </Router>
// //   );
// // }

// // export default App;

// import React, { useState } from "react";
// import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
// import Login from "./pages/Login";
// import Signup from "./pages/Signup";
// import BlogForm from "./pages/BlogForm";

// function App() {
//   const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("token"));
//   const [blogs, setBlogs] = useState([]);

//   const handleLogin = () => {
//     localStorage.setItem("token", "demoToken123");
//     setIsLoggedIn(true);
//   };

//   const handleLogout = () => {
//     localStorage.removeItem("token");
//     setIsLoggedIn(false);
//   };

//   const handleAddBlog = (blog) => {
//     setBlogs([...blogs, { ...blog, id: Date.now() }]);
//     alert("Blog published successfully 🎉");
//   };

//   return (
//     <Router>
//       <Routes>
//         {/* Home route */}
//         <Route
//           path="/"
//           element={
//             isLoggedIn ? (
//               <div className="flex flex-col items-center justify-center h-screen bg-gradient-to-r from-purple-400 via-pink-500 to-red-500 text-white">
//                 <h1 className="text-4xl font-bold mb-6">Welcome 🎉</h1>
//                 <button
//                   onClick={handleLogout}
//                   className="bg-white text-purple-600 px-6 py-2 rounded-lg shadow hover:bg-gray-200 transition mb-4"
//                 >
//                   Logout
//                 </button>
//                 <a
//                   href="/create"
//                   className="bg-yellow-400 text-black px-6 py-2 rounded-lg shadow hover:bg-yellow-500 transition"
//                 >
//                   ➕ Create Blog
//                 </a>
//               </div>
//             ) : (
//               <Navigate to="/login" replace />
//             )
//           }
//         />

//         {/* Login route */}
//         <Route
//           path="/login"
//           element={isLoggedIn ? <Navigate to="/" replace /> : <Login onLogin={handleLogin} />}
//         />

//         {/* Signup route */}
//         <Route
//           path="/signup"
//           element={isLoggedIn ? <Navigate to="/" replace /> : <Signup onSignup={handleLogin} />}
//         />

//         {/* BlogForm route */}
//         <Route
//           path="/create"
//           element={
//             isLoggedIn ? (
//               <BlogForm onSubmit={handleAddBlog} />
//             ) : (
//               <Navigate to="/login" replace />
//             )
//           }
//         />

//         {/* Catch all */}
//         <Route path="*" element={<Navigate to="/" replace />} />
//       </Routes>
//     </Router>
//   );
// }

// export default App;

// src/pages/BlogForm.jsx
import React, { useState } from "react";

function BlogForm({ onSubmit }) {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!title || !content) {
      alert("Please fill in all fields");
      return;
    }
    onSubmit({ title, content });
    setTitle("");
    setContent("");
  };

  return (
    <div className="flex items-center justify-center min-h-screen bg-gradient-to-r from-blue-400 via-indigo-500 to-purple-600">
      <div className="bg-white p-8 rounded-2xl shadow-lg w-full max-w-lg">
        <h2 className="text-3xl font-bold text-center text-indigo-600 mb-6">
          Create New Blog ✍️
        </h2>
        <form onSubmit={handleSubmit} className="space-y-5">
          <div>
            <label className="block text-gray-700 font-semibold mb-2">
              Blog Title
            </label>
            <input
              type="text"
              value={title}
              onChange={(e) => setTitle(e.target.value)}
              placeholder="Enter blog title"
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-400"
            />
          </div>
          <div>
            <label className="block text-gray-700 font-semibold mb-2">
              Blog Content
            </label>
            <textarea
              value={content}
              onChange={(e) => setContent(e.target.value)}
              placeholder="Write your blog here..."
              rows="6"
              className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-400"
            ></textarea>
          </div>
          <button
            type="submit"
            className="w-full bg-indigo-600 text-white py-2 rounded-lg hover:bg-indigo-700 transition duration-200"
          >
            Publish 🚀
          </button>
        </form>
      </div>
    </div>
  );
}

export default BlogForm;
