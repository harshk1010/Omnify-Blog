import React, { useState } from "react";
import { Link } from "react-router-dom";
import BlogForm from "../components/BlogForm";

function BlogList({ posts, setPosts }) {
  const [editingPost, setEditingPost] = useState(null);

  const handleSave = (post) => {
    if (editingPost) {
      setPosts(posts.map((p) => (p.id === editingPost.id ? { ...p, ...post } : p)));
      setEditingPost(null);
    } else {
      setPosts([...posts, { id: Date.now(), ...post }]);
    }
  };

  const handleDelete = (id) => {
    setPosts(posts.filter((p) => p.id !== id));
  };

  return (
    <div className="p-8 space-y-6">
      <h1 className="text-4xl font-bold text-center">Blog Manager ✍️</h1>
      <BlogForm onSave={handleSave} editingPost={editingPost} />
      <div className="grid md:grid-cols-2 gap-6">
        {posts.map((post) => (
          <div key={post.id} className="bg-white/20 backdrop-blur-md p-4 rounded-xl shadow-lg">
            <h2 className="text-2xl font-semibold">{post.title}</h2>
            <p className="truncate">{post.content}</p>
            <div className="flex gap-3 mt-3">
              <Link
                to={`/post/${post.id}`}
                className="bg-blue-500 px-3 py-1 rounded-lg hover:bg-blue-600"
              >
                View
              </Link>
              <button
                onClick={() => setEditingPost(post)}
                className="bg-yellow-500 px-3 py-1 rounded-lg hover:bg-yellow-600"
              >
                Edit
              </button>
              <button
                onClick={() => handleDelete(post.id)}
                className="bg-red-500 px-3 py-1 rounded-lg hover:bg-red-600"
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default BlogList;
