import React from "react";
import { useParams, Link } from "react-router-dom";

function BlogDetail({ posts }) {
  const { id } = useParams();
  const post = posts.find((p) => p.id === Number(id));

  if (!post) {
    return (
      <div className="p-8 text-center">
        <h1 className="text-2xl">Post not found</h1>
        <Link to="/" className="text-blue-400 underline">Go Back</Link>
      </div>
    );
  }

  return (
    <div className="p-8 space-y-4">
      <h1 className="text-4xl font-bold">{post.title}</h1>
      <p className="text-lg">{post.content}</p>
      <Link
        to="/"
        className="bg-purple-600 px-4 py-2 rounded-lg inline-block mt-4 hover:bg-purple-700"
      >
        Back to List
      </Link>
    </div>
  );
}

export default BlogDetail;
