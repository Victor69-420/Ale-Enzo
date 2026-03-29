<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ateliê Alê & Enzo — Costura Artesanal</title>
<link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:ital,wght@0,300;0,400;0,600;1,300;1,400&family=Jost:wght@200;300;400;500&display=swap" rel="stylesheet">
<style>
  :root {
    --cream: #F5F0EA;
    --warm-white: #FAFAF8;
    --charcoal: #1C1C1A;
    --mid: #4A4845;
    --light: #9A9490;
    --accent: #B8977E;
    --accent-dark: #8B6B55;
    --border: #E2DDD8;
    --success: #7A9E7E;
    --error: #C17070;
    --pix-green: #4CAF50;
  }
  *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }
  html { scroll-behavior: smooth; }
  body {
    font-family: 'Jost', sans-serif;
    background: var(--warm-white);
    color: var(--charcoal);
    cursor: none;
    overflow-x: hidden;
  }

  /* CUSTOM CURSOR */
  #cursor {
    width: 10px; height: 10px;
    border-radius: 50%;
    background: var(--accent);
    position: fixed; top: 0; left: 0;
    pointer-events: none;
    z-index: 9999;
    transform: translate(-50%, -50%);
    transition: transform 0.1s ease, width 0.25s ease, height 0.25s ease, background 0.25s ease;
    mix-blend-mode: multiply;
  }
  #cursor-ring {
    width: 36px; height: 36px;
    border-radius: 50%;
    border: 1px solid var(--accent);
    position: fixed; top: 0; left: 0;
    pointer-events: none;
    z-index: 9998;
    transform: translate(-50%, -50%);
    transition: transform 0.35s cubic-bezier(0.23,1,0.32,1), width 0.3s ease, height 0.3s ease, opacity 0.3s ease;
    opacity: 0.6;
  }
  body:hover #cursor { opacity: 1; }
  .cursor-hover #cursor { width: 16px; height: 16px; background: var(--accent-dark); }
  .cursor-hover #cursor-ring { width: 52px; height: 52px; opacity: 0.3; }

  /* NAV */
  nav {
    position: fixed; top: 0; left: 0; right: 0; z-index: 100;
    display: flex; align-items: center; justify-content: space-between;
    padding: 0 4rem;
    height: 72px;
    background: rgba(250,250,248,0.92);
    backdrop-filter: blur(12px);
    border-bottom: 1px solid transparent;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
  }
  nav.scrolled { border-color: var(--border); box-shadow: 0 2px 24px rgba(0,0,0,0.04); }
  .logo {
    font-family: 'Cormorant Garamond', serif;
    font-size: 1.5rem;
    font-weight: 400;
    letter-spacing: 0.04em;
    color: var(--charcoal);
    text-decoration: none;
  }
  .logo span { color: var(--accent); font-style: italic; }
  .nav-links { display: flex; gap: 2.5rem; list-style: none; }
  .nav-links a {
    font-size: 0.75rem;
    font-weight: 400;
    letter-spacing: 0.12em;
    text-transform: uppercase;
    color: var(--mid);
    text-decoration: none;
    position: relative;
    transition: color 0.2s;
  }
  .nav-links a::after {
    content: '';
    position: absolute; bottom: -3px; left: 0;
    width: 0; height: 1px;
    background: var(--accent);
    transition: width 0.3s ease;
  }
  .nav-links a:hover { color: var(--charcoal); }
  .nav-links a:hover::after { width: 100%; }
  .nav-right { display: flex; gap: 1.2rem; align-items: center; }
  .cart-btn {
    position: relative;
    background: none; border: none;
    font-size: 1.2rem; cursor: none;
    color: var(--charcoal);
    transition: color 0.2s;
  }
  .cart-btn:hover { color: var(--accent); }
  #cart-count {
    position: absolute; top: -6px; right: -8px;
    background: var(--accent);
    color: white;
    font-size: 0.6rem;
    width: 16px; height: 16px;
    border-radius: 50%;
    display: none; align-items: center; justify-content: center;
    font-weight: 500;
  }

  /* HERO */
  .hero {
    height: 100vh;
    display: flex; align-items: center; justify-content: center;
    flex-direction: column;
    text-align: center;
    position: relative;
    overflow: hidden;
    background: var(--cream);
  }
  .hero-bg {
    position: absolute; inset: 0;
    background: radial-gradient(ellipse at 70% 30%, rgba(184,151,126,0.12) 0%, transparent 60%),
                radial-gradient(ellipse at 20% 80%, rgba(184,151,126,0.08) 0%, transparent 50%);
  }
  .hero-tag {
    font-size: 0.7rem; letter-spacing: 0.2em; text-transform: uppercase;
    color: var(--accent); margin-bottom: 2rem;
    opacity: 0; animation: fadeUp 0.8s 0.3s ease forwards;
  }
  .hero h1 {
    font-family: 'Cormorant Garamond', serif;
    font-size: clamp(3.5rem, 8vw, 7rem);
    font-weight: 300;
    line-height: 1.05;
    letter-spacing: -0.01em;
    color: var(--charcoal);
    opacity: 0; animation: fadeUp 0.9s 0.5s ease forwards;
  }
  .hero h1 em { font-style: italic; color: var(--accent); }
  .hero-sub {
    margin-top: 1.5rem;
    font-size: 0.85rem; font-weight: 300;
    letter-spacing: 0.08em;
    color: var(--light);
    opacity: 0; animation: fadeUp 0.9s 0.7s ease forwards;
  }
  .hero-cta {
    margin-top: 3rem;
    display: flex; gap: 1rem;
    opacity: 0; animation: fadeUp 0.9s 0.9s ease forwards;
  }
  .btn-primary {
    padding: 0.85rem 2.4rem;
    background: var(--charcoal);
    color: white;
    border: 1px solid var(--charcoal);
    font-family: 'Jost', sans-serif;
    font-size: 0.72rem; font-weight: 400;
    letter-spacing: 0.14em; text-transform: uppercase;
    cursor: none; text-decoration: none;
    transition: background 0.25s, color 0.25s, transform 0.2s;
  }
  .btn-primary:hover { background: var(--accent); border-color: var(--accent); transform: translateY(-2px); }
  .btn-outline {
    padding: 0.85rem 2.4rem;
    background: transparent;
    color: var(--charcoal);
    border: 1px solid var(--charcoal);
    font-family: 'Jost', sans-serif;
    font-size: 0.72rem; font-weight: 400;
    letter-spacing: 0.14em; text-transform: uppercase;
    cursor: none; text-decoration: none;
    transition: background 0.25s, color 0.25s, transform 0.2s;
  }
  .btn-outline:hover { background: var(--charcoal); color: white; transform: translateY(-2px); }
  .scroll-hint {
    position: absolute; bottom: 2.5rem; left: 50%; transform: translateX(-50%);
    display: flex; flex-direction: column; align-items: center; gap: 0.5rem;
    font-size: 0.65rem; letter-spacing: 0.15em; text-transform: uppercase;
    color: var(--light);
    animation: fadeUp 1s 1.2s ease forwards; opacity: 0;
  }
  .scroll-line {
    width: 1px; height: 40px;
    background: linear-gradient(to bottom, var(--accent), transparent);
    animation: scrollAnim 2s 1.5s ease-in-out infinite;
  }
  @keyframes scrollAnim { 0%,100% { transform: scaleY(1); } 50% { transform: scaleY(0.5); } }
  @keyframes fadeUp { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }

  /* SECTION BASE */
  section { padding: 6rem 4rem; }
  .section-label {
    font-size: 0.65rem; letter-spacing: 0.22em; text-transform: uppercase;
    color: var(--accent); margin-bottom: 0.8rem;
  }
  .section-title {
    font-family: 'Cormorant Garamond', serif;
    font-size: clamp(2rem, 4vw, 3.2rem);
    font-weight: 300;
    line-height: 1.2;
    color: var(--charcoal);
  }
  .section-title em { font-style: italic; color: var(--accent); }
  .divider {
    width: 48px; height: 1px;
    background: var(--accent);
    margin: 1.5rem 0;
  }

  /* SOBRE */
  .sobre { background: var(--warm-white); }
  .sobre-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 6rem;
    align-items: center;
    max-width: 1100px; margin: 4rem auto 0;
  }
  .sobre-img {
    aspect-ratio: 3/4;
    background: var(--cream);
    position: relative;
    overflow: hidden;
  }
  .sobre-img-inner {
    position: absolute; inset: 12px;
    background: linear-gradient(135deg, var(--border), var(--cream));
    display: flex; align-items: center; justify-content: center;
    font-family: 'Cormorant Garamond', serif;
    font-size: 4rem; color: var(--light);
    font-style: italic;
  }
  .sobre-img::before {
    content: '';
    position: absolute; top: -12px; right: -12px;
    width: 80%; height: 80%;
    border: 1px solid var(--border);
    z-index: -1;
  }
  .sobre-text p {
    font-size: 0.9rem; font-weight: 300;
    line-height: 1.9; color: var(--mid);
    margin-bottom: 1.2rem;
  }
  .sobre-stats {
    display: flex; gap: 2.5rem; margin-top: 2.5rem;
    padding-top: 2.5rem;
    border-top: 1px solid var(--border);
  }
  .stat-num {
    font-family: 'Cormorant Garamond', serif;
    font-size: 2.5rem; font-weight: 300;
    color: var(--accent);
  }
  .stat-label {
    font-size: 0.7rem; letter-spacing: 0.1em; text-transform: uppercase;
    color: var(--light); margin-top: 0.2rem;
  }

  /* PRODUTOS */
  .produtos { background: var(--cream); }
  .produtos-header {
    display: flex; justify-content: space-between; align-items: flex-end;
    max-width: 1200px; margin: 0 auto 3rem;
  }
  .filter-tabs { display: flex; gap: 0.5rem; flex-wrap: wrap; }
  .filter-tab {
    padding: 0.4rem 1.1rem;
    border: 1px solid var(--border);
    background: transparent;
    font-family: 'Jost', sans-serif;
    font-size: 0.7rem; letter-spacing: 0.1em; text-transform: uppercase;
    color: var(--mid); cursor: none;
    transition: all 0.2s;
  }
  .filter-tab.active, .filter-tab:hover {
    background: var(--charcoal); color: white; border-color: var(--charcoal);
  }
  .product-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(290px, 1fr));
    gap: 2rem;
    max-width: 1200px; margin: 0 auto;
  }
  .product-card {
    background: var(--warm-white);
    position: relative; overflow: hidden;
    transition: transform 0.35s ease, box-shadow 0.35s ease;
    cursor: none;
  }
  .product-card:hover { transform: translateY(-6px); box-shadow: 0 20px 48px rgba(0,0,0,0.08); }
  .product-img {
    aspect-ratio: 1;
    background: var(--cream);
    position: relative; overflow: hidden;
    display: flex; align-items: center; justify-content: center;
  }
  .product-emoji { font-size: 5rem; opacity: 0.5; }
  .product-badge {
    position: absolute; top: 1rem; left: 1rem;
    background: var(--accent); color: white;
    font-size: 0.6rem; letter-spacing: 0.12em; text-transform: uppercase;
    padding: 0.25rem 0.7rem;
  }
  .product-overlay {
    position: absolute; inset: 0;
    background: rgba(28,28,26,0.6);
    display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 0.8rem;
    opacity: 0; transition: opacity 0.3s;
  }
  .product-card:hover .product-overlay { opacity: 1; }
  .overlay-btn {
    padding: 0.7rem 1.8rem;
    background: white; color: var(--charcoal);
    border: none;
    font-family: 'Jost', sans-serif;
    font-size: 0.7rem; font-weight: 500;
    letter-spacing: 0.12em; text-transform: uppercase;
    cursor: none;
    transform: translateY(8px);
    transition: transform 0.3s, background 0.2s;
  }
  .product-card:hover .overlay-btn { transform: translateY(0); }
  .overlay-btn:hover { background: var(--accent); color: white; }
  .product-info { padding: 1.4rem; }
  .product-name {
    font-family: 'Cormorant Garamond', serif;
    font-size: 1.2rem; font-weight: 400;
    color: var(--charcoal); margin-bottom: 0.3rem;
  }
  .product-desc { font-size: 0.78rem; color: var(--light); font-weight: 300; margin-bottom: 0.8rem; }

  /* SIZE SELECTOR */
  .size-selector {
    display: flex; gap: 0.4rem; margin-bottom: 0.9rem; flex-wrap: wrap;
  }
  .size-btn {
    padding: 0.28rem 0.65rem;
    border: 1px solid var(--border);
    background: transparent;
    font-family: 'Jost', sans-serif;
    font-size: 0.65rem; letter-spacing: 0.08em;
    color: var(--mid); cursor: none;
    transition: all 0.18s;
  }
  .size-btn.active {
    background: var(--charcoal); color: white; border-color: var(--charcoal);
  }
  .size-btn:hover:not(.active) { border-color: var(--accent); color: var(--accent); }

  .product-footer { display: flex; align-items: flex-end; justify-content: space-between; gap: 1rem; }
  .price-block { display: flex; flex-direction: column; gap: 0.15rem; }
  .price-credit {
    font-size: 0.78rem; color: var(--light); font-weight: 300;
  }
  .price-credit span { text-decoration: line-through; }
  .product-price { font-size: 1.05rem; font-weight: 500; color: var(--charcoal); }
  .price-pix {
    font-size: 0.78rem; color: var(--pix-green); font-weight: 500;
    display: flex; align-items: center; gap: 0.3rem;
  }
  .price-pix-badge {
    font-size: 0.58rem; background: #e8f5e9; color: var(--pix-green);
    padding: 0.1rem 0.4rem; border-radius: 2px; letter-spacing: 0.06em;
  }
  .add-cart {
    width: 36px; height: 36px; flex-shrink: 0;
    border: 1px solid var(--charcoal);
    background: none; color: var(--charcoal);
    font-size: 1.1rem; cursor: none;
    display: flex; align-items: center; justify-content: center;
    transition: all 0.2s;
  }
  .add-cart:hover { background: var(--charcoal); color: white; }

  /* TABELA DE PREÇOS */
  .precos { background: var(--warm-white); }
  .precos-inner { max-width: 900px; margin: 0 auto; }
  .preco-table {
    width: 100%; border-collapse: collapse; margin-top: 3rem;
  }
  .preco-table thead th {
    text-align: left;
    font-size: 0.68rem; letter-spacing: 0.14em; text-transform: uppercase;
    color: var(--light); font-weight: 400;
    padding: 0.8rem 1.5rem;
    border-bottom: 2px solid var(--border);
  }
  .preco-table tbody tr {
    border-bottom: 1px solid var(--border);
    transition: background 0.2s;
  }
  .preco-table tbody tr:hover { background: var(--cream); }
  .preco-table td {
    padding: 1.2rem 1.5rem;
    font-size: 0.85rem; font-weight: 300;
    color: var(--mid);
  }
  .preco-table td:first-child {
    font-family: 'Cormorant Garamond', serif;
    font-size: 1rem; color: var(--charcoal); font-weight: 400;
  }
  .preco-table td.price-cell { font-weight: 500; color: var(--accent); }
  .preco-table td.pix-cell { font-weight: 500; color: var(--pix-green); font-size: 0.82rem; }
  .preco-category {
    background: var(--cream) !important;
    font-size: 0.65rem !important;
    letter-spacing: 0.18em; text-transform: uppercase;
    color: var(--light) !important;
    font-family: 'Jost', sans-serif !important;
    padding: 0.5rem 1.5rem !important;
  }

  /* FRETE */
  .frete-section { background: var(--cream); padding: 5rem 4rem; }
  .frete-box {
    max-width: 500px; margin: 3rem auto 0;
    background: var(--warm-white);
    padding: 2.5rem;
    border: 1px solid var(--border);
  }
  .frete-box h3 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 1.4rem; font-weight: 400;
    margin-bottom: 1.5rem;
  }
  .input-group { margin-bottom: 1rem; }
  .input-group label {
    display: block;
    font-size: 0.68rem; letter-spacing: 0.12em; text-transform: uppercase;
    color: var(--light); margin-bottom: 0.5rem;
  }
  .input-row { display: flex; gap: 0.5rem; }
  .input-field {
    width: 100%; padding: 0.8rem 1rem;
    border: 1px solid var(--border);
    background: var(--cream);
    font-family: 'Jost', sans-serif;
    font-size: 0.85rem; color: var(--charcoal);
    outline: none;
    transition: border-color 0.2s;
  }
  .input-field:focus { border-color: var(--accent); }
  .btn-frete {
    padding: 0.8rem 1.5rem;
    background: var(--charcoal); color: white; border: none;
    font-family: 'Jost', sans-serif;
    font-size: 0.72rem; letter-spacing: 0.1em; text-transform: uppercase;
    cursor: none; white-space: nowrap;
    transition: background 0.2s;
  }
  .btn-frete:hover { background: var(--accent); }
  #frete-result {
    margin-top: 1.2rem; padding: 1rem;
    background: var(--cream);
    border-left: 2px solid var(--accent);
    display: none;
  }
  .frete-option { display: flex; justify-content: space-between; margin-bottom: 0.5rem; }
  .frete-option:last-child { margin-bottom: 0; }
  .frete-name { font-size: 0.8rem; color: var(--mid); }
  .frete-price { font-size: 0.85rem; font-weight: 500; color: var(--accent); }

  /* CARRINHO SIDEBAR */
  .cart-overlay {
    position: fixed; inset: 0;
    background: rgba(28,28,26,0.5);
    z-index: 200; opacity: 0; pointer-events: none;
    transition: opacity 0.3s;
  }
  .cart-overlay.open { opacity: 1; pointer-events: all; }
  .cart-sidebar {
    position: fixed; top: 0; right: 0; bottom: 0;
    width: min(420px, 100vw);
    background: var(--warm-white);
    z-index: 201;
    transform: translateX(100%);
    transition: transform 0.4s cubic-bezier(0.23,1,0.32,1);
    display: flex; flex-direction: column;
  }
  .cart-sidebar.open { transform: translateX(0); }
  .cart-header {
    display: flex; justify-content: space-between; align-items: center;
    padding: 2rem; border-bottom: 1px solid var(--border);
  }
  .cart-header h2 {
    font-family: 'Cormorant Garamond', serif;
    font-size: 1.4rem; font-weight: 400;
  }
  .close-cart { background: none; border: none; font-size: 1.3rem; cursor: none; color: var(--mid); }
  .cart-items { flex: 1; overflow-y: auto; padding: 1.5rem 2rem; }
  .cart-empty {
    text-align: center; padding: 3rem 0;
    font-size: 0.85rem; color: var(--light);
  }
  .cart-empty-icon { font-size: 3rem; margin-bottom: 1rem; opacity: 0.4; }
  .cart-item {
    display: flex; gap: 1rem; margin-bottom: 1.5rem;
    padding-bottom: 1.5rem; border-bottom: 1px solid var(--border);
  }
  .cart-item-img {
    width: 70px; height: 70px;
    background: var(--cream);
    flex-shrink: 0;
    display: flex; align-items: center; justify-content: center;
    font-size: 2rem;
  }
  .cart-item-info { flex: 1; }
  .cart-item-name { font-family: 'Cormorant Garamond', serif; font-size: 1rem; }
  .cart-item-size { font-size: 0.7rem; color: var(--light); margin-top: 0.1rem; }
  .cart-item-price { font-size: 0.8rem; color: var(--accent); margin-top: 0.2rem; }
  .cart-item-pix { font-size: 0.72rem; color: var(--pix-green); }
  .cart-item-qty {
    display: flex; align-items: center; gap: 0.6rem;
    margin-top: 0.6rem;
  }
  .qty-btn {
    width: 24px; height: 24px;
    border: 1px solid var(--border);
    background: none; font-size: 0.9rem; cursor: none;
    display: flex; align-items: center; justify-content: center;
    transition: all 0.2s;
  }
  .qty-btn:hover { background: var(--charcoal); color: white; border-color: var(--charcoal); }
  .qty-num { font-size: 0.85rem; min-width: 20px; text-align: center; }
  .remove-item { font-size: 0.7rem; color: var(--light); background: none; border: none; cursor: none; margin-left: auto; }
  .remove-item:hover { color: var(--error); }
  .cart-footer { padding: 1.5rem 2rem; border-top: 1px solid var(--border); }
  .cart-total-row { display: flex; justify-content: space-between; margin-bottom: 0.5rem; }
  .cart-total-label { font-size: 0.75rem; letter-spacing: 0.1em; text-transform: uppercase; color: var(--light); }
  .cart-total-value { font-family: 'Cormorant Garamond', serif; font-size: 1.4rem; }
  .cart-pix-total { font-size: 0.82rem; color: var(--pix-green); font-weight: 500; }

  /* PAGAMENTO */
  .payment-tabs {
    display: flex; gap: 0; margin-top: 1rem;
    border: 1px solid var(--border);
    width: 100%;
  }
  .pay-tab {
    flex: 1; padding: 0.8rem;
    background: none; border: none; border-right: 1px solid var(--border);
    font-family: 'Jost', sans-serif;
    font-size: 0.68rem; letter-spacing: 0.08em; text-transform: uppercase;
    color: var(--light); cursor: none;
    transition: all 0.2s;
  }
  .pay-tab:last-child { border-right: none; }
  .pay-tab.active { background: var(--charcoal); color: white; }
  .pay-content { padding: 1.2rem 0; display: none; }
  .pay-content.active { display: block; }
  .pix-code {
    display: flex; align-items: center; gap: 0.8rem;
    background: var(--cream); padding: 0.8rem 1rem;
    font-size: 0.78rem; color: var(--mid); font-family: monospace;
    word-break: break-all;
  }
  .copy-btn {
    background: var(--charcoal); color: white; border: none;
    padding: 0.4rem 0.8rem; font-size: 0.65rem;
    cursor: none; white-space: nowrap; flex-shrink: 0;
    transition: background 0.2s;
  }
  .copy-btn:hover { background: var(--accent); }
  .parcelas { font-size: 0.78rem; color: var(--mid); }
  .parcelas span { color: var(--accent); font-weight: 500; }
  .checkout-btn {
    width: 100%; margin-top: 1.2rem;
    padding: 1rem;
    background: var(--charcoal); color: white; border: none;
    font-family: 'Jost', sans-serif;
    font-size: 0.72rem; letter-spacing: 0.14em; text-transform: uppercase;
    cursor: none; transition: background 0.2s;
  }
  .checkout-btn:hover { background: var(--accent); }

  /* SOCIAL / CONTATO */
  .social-section {
    background: var(--charcoal);
    padding: 6rem 4rem;
    text-align: center;
    color: white;
  }
  .social-section .section-label { color: var(--accent); }
  .social-section .section-title { color: white; }
  .social-section .divider { margin: 1.5rem auto; }
  .social-links {
    display: flex; gap: 1.5rem; justify-content: center;
    margin-top: 3rem; flex-wrap: wrap;
  }
  .social-link {
    display: flex; flex-direction: column; align-items: center; gap: 0.6rem;
    padding: 1.8rem 2rem; min-width: 120px;
    border: 1px solid rgba(255,255,255,0.1);
    color: white; text-decoration: none;
    transition: all 0.3s;
    position: relative; overflow: hidden;
  }
  .social-link::before {
    content: '';
    position: absolute; inset: 0;
    background: var(--accent);
    transform: translateY(100%);
    transition: transform 0.3s ease;
  }
  .social-link:hover::before { transform: translateY(0); }
  .social-link span { position: relative; z-index: 1; }
  .social-icon { font-size: 1.8rem; }
  .social-name {
    font-size: 0.65rem; letter-spacing: 0.14em; text-transform: uppercase;
  }
  .contact-row {
    display: flex; gap: 4rem; justify-content: center;
    margin-top: 4rem; padding-top: 4rem;
    border-top: 1px solid rgba(255,255,255,0.08);
    flex-wrap: wrap;
  }
  .contact-item { text-align: center; }
  .contact-label {
    font-size: 0.65rem; letter-spacing: 0.16em; text-transform: uppercase;
    color: var(--accent); margin-bottom: 0.5rem;
  }
  .contact-value { font-size: 0.9rem; font-weight: 300; color: rgba(255,255,255,0.7); }

  /* NEWSLETTER */
  .newsletter {
    background: var(--cream); padding: 5rem 4rem;
    text-align: center;
  }
  .newsletter-form {
    display: flex; gap: 0; max-width: 440px; margin: 2rem auto 0;
  }
  .newsletter-input {
    flex: 1; padding: 0.9rem 1.2rem;
    border: 1px solid var(--border); border-right: none;
    background: white;
    font-family: 'Jost', sans-serif; font-size: 0.85rem;
    outline: none; transition: border-color 0.2s;
  }
  .newsletter-input:focus { border-color: var(--accent); }
  .newsletter-btn {
    padding: 0.9rem 1.5rem;
    background: var(--charcoal); color: white; border: 1px solid var(--charcoal);
    font-family: 'Jost', sans-serif;
    font-size: 0.7rem; letter-spacing: 0.12em; text-transform: uppercase;
    cursor: none; transition: background 0.2s;
  }
  .newsletter-btn:hover { background: var(--accent); border-color: var(--accent); }

  /* FOOTER */
  footer {
    background: var(--charcoal); color: rgba(255,255,255,0.4);
    padding: 2rem 4rem;
    display: flex; justify-content: space-between; align-items: center;
    border-top: 1px solid rgba(255,255,255,0.06);
    font-size: 0.72rem; font-weight: 300;
    flex-wrap: wrap; gap: 1rem;
  }
  footer a { color: rgba(255,255,255,0.4); text-decoration: none; transition: color 0.2s; }
  footer a:hover { color: var(--accent); }
  .footer-logo { font-family: 'Cormorant Garamond', serif; font-size: 1.1rem; color: white; }
  .footer-logo span { color: var(--accent); font-style: italic; }

  /* TOAST */
  #toast {
    position: fixed; bottom: 2rem; right: 2rem;
    background: var(--charcoal); color: white;
    padding: 1rem 1.5rem; z-index: 500;
    font-size: 0.78rem; letter-spacing: 0.05em;
    transform: translateY(80px); opacity: 0;
    transition: all 0.4s cubic-bezier(0.23,1,0.32,1);
    border-left: 3px solid var(--accent);
  }
  #toast.show { transform: translateY(0); opacity: 1; }

  /* REVEAL */
  .reveal { opacity: 0; transform: translateY(30px); transition: opacity 0.7s ease, transform 0.7s ease; }
  .reveal.visible { opacity: 1; transform: translateY(0); }

  /* PIX BANNER */
  .pix-banner {
    background: linear-gradient(135deg, #1b5e20, #2e7d32);
    color: white;
    text-align: center;
    padding: 0.7rem 2rem;
    font-size: 0.72rem;
    letter-spacing: 0.1em;
    text-transform: uppercase;
  }
  .pix-banner strong { color: #a5d6a7; }

  @media (max-width: 768px) {
    nav { padding: 0 1.5rem; }
    .nav-links { display: none; }
    section { padding: 4rem 1.5rem; }
    .sobre-grid { grid-template-columns: 1fr; gap: 3rem; }
    .hero h1 { font-size: 3rem; }
    .social-section, .frete-section, .newsletter { padding: 4rem 1.5rem; }
    footer { padding: 1.5rem; flex-direction: column; text-align: center; }
    .contact-row { gap: 2rem; }
    .produtos-header { flex-direction: column; gap: 1rem; align-items: flex-start; }
  }
</style>
</head>
<body>

<div id="cursor"></div>
<div id="cursor-ring"></div>

<!-- PIX BANNER -->
<div class="pix-banner">
  💚 Pague com <strong>PIX</strong> e ganhe <strong>10% de desconto</strong> em todos os produtos
</div>

<!-- CART OVERLAY -->
<div class="cart-overlay" id="cartOverlay" onclick="toggleCart()"></div>
<div class="cart-sidebar" id="cartSidebar">
  <div class="cart-header">
    <h2>Seu Carrinho</h2>
    <button class="close-cart" onclick="toggleCart()">✕</button>
  </div>
  <div class="cart-items" id="cartItems">
    <div class="cart-empty">
      <div class="cart-empty-icon">🛍️</div>
      <p>Seu carrinho está vazio</p>
    </div>
  </div>
  <div class="cart-footer" id="cartFooter" style="display:none">
    <div class="cart-total-row">
      <span class="cart-total-label">Subtotal (Cartão)</span>
      <span class="cart-total-value" id="cartTotal">R$ 0,00</span>
    </div>
    <div class="cart-total-row" style="margin-bottom:0.4rem">
      <span class="cart-total-label" style="color:var(--pix-green)">💚 Subtotal PIX (−10%)</span>
      <span class="cart-pix-total" id="cartPixTotal">R$ 0,00</span>
    </div>
    <div class="cart-total-row" style="margin-bottom:1.2rem">
      <span class="cart-total-label" style="font-size:0.68rem">Frete calculado no checkout</span>
      <span style="font-size:0.75rem;color:var(--light)">—</span>
    </div>

    <!-- PAGAMENTO -->
    <div class="payment-tabs">
      <button class="pay-tab active" onclick="switchPay('pix',this)">PIX</button>
      <button class="pay-tab" onclick="switchPay('credito',this)">Crédito</button>
      <button class="pay-tab" onclick="switchPay('debito',this)">Débito</button>
    </div>
    <div class="pay-content active" id="pay-pix">
      <p style="font-size:0.75rem;color:var(--light);margin-bottom:0.8rem;margin-top:0.8rem">Chave PIX:</p>
      <div class="pix-code">
        <span>atelie.aleenzo@gmail.com</span>
        <button class="copy-btn" onclick="copyPix()">Copiar</button>
      </div>
      <p style="font-size:0.72rem;color:var(--pix-green);margin-top:0.6rem">💚 10% de desconto no PIX — automático!</p>
    </div>
    <div class="pay-content" id="pay-credito">
      <p class="parcelas" style="margin-top:0.8rem">Parcelamento em até <span>12x sem juros</span></p>
      <p class="parcelas" style="margin-top:0.4rem">Aceitamos: Visa, Mastercard, Elo, Amex</p>
    </div>
    <div class="pay-content" id="pay-debito">
      <p class="parcelas" style="margin-top:0.8rem">Aceitamos cartões de débito das principais bandeiras.</p>
    </div>
    <button class="checkout-btn" onclick="checkout()">Finalizar Compra</button>
  </div>
</div>

<!-- NAV -->
<nav id="mainNav">
  <a href="#" class="logo">Ateliê <span>Alê & Enzo</span></a>
  <ul class="nav-links">
    <li><a href="#sobre">Sobre</a></li>
    <li><a href="#produtos">Produtos</a></li>
    <li><a href="#precos">Tabela</a></li>
    <li><a href="#frete">Frete</a></li>
    <li><a href="#contato">Contato</a></li>
  </ul>
  <div class="nav-right">
    <button class="cart-btn" onclick="toggleCart()">
      🛍
      <span id="cart-count">0</span>
    </button>
  </div>
</nav>

<!-- HERO -->
<section class="hero" id="hero">
  <div class="hero-bg"></div>
  <p class="hero-tag">✦ Costura Artesanal — Rio de Janeiro</p>
  <h1>Ateliê<br><em>Alê&Enzo</em></h1>
  <p class="hero-sub">Bolsas, nécessaires e acessórios costurados à mão com amor</p>
  <div class="hero-cta">
    <a href="#produtos" class="btn-primary">Ver Coleção</a>
    <a href="#sobre" class="btn-outline">Nossa História</a>
  </div>
  <div class="scroll-hint">
    <div class="scroll-line"></div>
    <span>Rolar</span>
  </div>
</section>

<!-- SOBRE -->
<section class="sobre" id="sobre">
  <div class="sobre-grid">
    <div class="sobre-img reveal">
      <div class="sobre-img-inner">A&E</div>
    </div>
    <div class="sobre-text reveal">
      <p class="section-label">Nossa História</p>
      <h2 class="section-title">Costurado com <em>alma</em> e cuidado</h2>
      <div class="divider"></div>
      <p>O Ateliê Alê & Enzo nasceu da paixão pela costura artesanal e pela criação de peças que aliam beleza, função e durabilidade. Cada bolsa, necessário e acessório é costurado à mão, do corte ao acabamento.</p>
      <p>Trabalhamos com tecidos e materiais selecionados, garantindo que cada peça seja única e feita especialmente para quem a carrega. Acreditamos que um bom acessório conta a história de quem o usa.</p>
      <div class="sobre-stats">
        <div>
          <div class="stat-num">9+</div>
          <div class="stat-label">Anos de Ateliê</div>
        </div>
        <div>
          <div class="stat-num">650+</div>
          <div class="stat-label">Peças Entregues</div>
        </div>
        <div>
          <div class="stat-num">100%</div>
          <div class="stat-label">Handmade</div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- PRODUTOS -->
<section class="produtos" id="produtos">
  <div class="produtos-header">
    <div>
      <p class="section-label">Coleção</p>
      <h2 class="section-title">Nossas <em>Peças</em></h2>
    </div>
    <div class="filter-tabs">
      <button class="filter-tab active" onclick="filterProducts('todos',this)">Todos</button>
      <button class="filter-tab" onclick="filterProducts('bolsas',this)">Bolsas</button>
      <button class="filter-tab" onclick="filterProducts('marmita',this)">Marmita</button>
      <button class="filter-tab" onclick="filterProducts('acessorios',this)">Acessórios</button>
    </div>
  </div>
  <div class="product-grid" id="productGrid"></div>
</section>

<!-- TABELA DE PREÇOS -->
<section class="precos" id="precos">
  <div class="precos-inner">
    <p class="section-label reveal">Transparência</p>
    <h2 class="section-title reveal">Tabela de <em>Preços</em></h2>
    <div class="divider reveal"></div>
    <table class="preco-table reveal">
      <thead>
        <tr>
          <th>Produto / Serviço</th>
          <th>Descrição</th>
          <th>Cartão / Débito</th>
          <th>💚 PIX (−10%)</th>
        </tr>
      </thead>
      <tbody>
        <tr><td colspan="4" class="preco-category">— Bolsas —</td></tr>
        <tr><td>Bolsa Tote</td><td>Canvas ou lona, alça longa</td><td class="price-cell">R$ 120,00</td><td class="pix-cell">R$ 108,00</td></tr>
        <tr><td>Shoulder Bag</td><td>Couro sintético, alça ajustável</td><td class="price-cell">R$ 150,00</td><td class="pix-cell">R$ 135,00</td></tr>
        <tr><td>Bolsa de Praia</td><td>Juta natural + forro interno</td><td class="price-cell">R$ 95,00</td><td class="pix-cell">R$ 85,50</td></tr>
        <tr><td>Clutch de Festa</td><td>Tecido bordado, forro de cetim</td><td class="price-cell">R$ 110,00</td><td class="pix-cell">R$ 99,00</td></tr>
        <tr><td>Mochila Mini</td><td>Lona premium, bolso frontal</td><td class="price-cell">R$ 180,00</td><td class="pix-cell">R$ 162,00</td></tr>
        <tr><td colspan="4" class="preco-category">— Bolsa de Marmita —</td></tr>
        <tr><td>Bolsa Marmita P</td><td>Térmica, cabe 1 marmita</td><td class="price-cell">R$ 75,00</td><td class="pix-cell">R$ 67,50</td></tr>
        <tr><td>Bolsa Marmita M</td><td>Térmica, cabe 2 marmitas</td><td class="price-cell">R$ 95,00</td><td class="pix-cell">R$ 85,50</td></tr>
        <tr><td>Bolsa Marmita G</td><td>Térmica, família / delivery</td><td class="price-cell">R$ 130,00</td><td class="pix-cell">R$ 117,00</td></tr>
        <tr><td colspan="4" class="preco-category">— Nécessaires & Acessórios —</td></tr>
        <tr><td>Nécessaire P</td><td>Zíper duplo, interior forrado</td><td class="price-cell">R$ 55,00</td><td class="pix-cell">R$ 49,50</td></tr>
        <tr><td>Nécessaire G</td><td>Tamanho viagem, bolso externo</td><td class="price-cell">R$ 80,00</td><td class="pix-cell">R$ 72,00</td></tr>
        <tr><td>Porta-Treco</td><td>Chaveiro bolsinha, várias cores</td><td class="price-cell">R$ 35,00</td><td class="pix-cell">R$ 31,50</td></tr>
        <tr><td colspan="4" class="preco-category">— Serviços & Encomendas —</td></tr>
        <tr><td>Encomenda Personalizada</td><td>Tecido, cor e tamanho à escolha</td><td class="price-cell">A partir de R$ 80,00</td><td class="pix-cell">Consultar</td></tr>
        <tr><td>Lembrancinha Evento</td><td>Casamento, chá de bebê, etc.</td><td class="price-cell">A partir de R$ 18,00/un</td><td class="pix-cell">Mín. 20 un.</td></tr>
        <tr><td>Reparo / Ajuste</td><td>Zíper, alça, forro, acabamento</td><td class="price-cell">A partir de R$ 25,00</td><td class="pix-cell">Consultar</td></tr>
      </tbody>
    </table>
    <p style="font-size:0.75rem;color:var(--light);margin-top:1.5rem;text-align:center;font-weight:300">
      * Preços sujeitos a alteração. Frete não incluso. Encomendas com prazo de 7 a 14 dias úteis.
    </p>
  </div>
</section>

<!-- FRETE -->
<section class="frete-section" id="frete">
  <div style="text-align:center">
    <p class="section-label reveal">Entrega</p>
    <h2 class="section-title reveal">Calcule o <em>Frete</em></h2>
  </div>
  <div class="frete-box reveal">
    <h3>Informe seu CEP</h3>
    <div class="input-group">
      <label>CEP</label>
      <div class="input-row">
        <input class="input-field" id="cepInput" type="text" placeholder="00000-000" maxlength="9" oninput="formatCep(this)">
        <button class="btn-frete" onclick="calcFrete()">Calcular</button>
      </div>
    </div>
    <div id="frete-result">
      <div class="frete-option"><span class="frete-name">📦 PAC (Correios)</span><span class="frete-price" id="frete-pac">—</span></div>
      <div class="frete-option"><span class="frete-name">⚡ SEDEX</span><span class="frete-price" id="frete-sedex">—</span></div>
      <div class="frete-option"><span class="frete-name">🛵 MotoUber (RJ)</span><span class="frete-price" id="frete-moto">—</span></div>
    </div>
  </div>
</section>

<!-- SOCIAL / CONTATO -->
<section class="social-section" id="contato">
  <p class="section-label">Conecte-se</p>
  <h2 class="section-title">Nos siga nas <em>redes</em></h2>
  <div class="divider"></div>
  <div class="social-links">
    <a href="https://www.instagram.com/atelierale_enzo" target="_blank" class="social-link">
      <span class="social-icon">📸</span>
      <span class="social-name">Instagram</span>
    </a>
    <a href="https://www.facebook.com/Alessa.Enzo" target="_blank" class="social-link">
      <span class="social-icon">📘</span>
      <span class="social-name">Facebook</span>
    </a>
    <a href="https://wa.me/5521979990967" target="_blank" class="social-link">
      <span class="social-icon">💬</span>
      <span class="social-name">WhatsApp</span>
    </a>
  </div>
  <div class="contact-row">
    <div class="contact-item">
      <div class="contact-label">Email</div>
      <div class="contact-value">alessakika@gmail.com</div>
    </div>
    <div class="contact-item">
      <div class="contact-label">WhatsApp</div>
      <div class="contact-value">(21) 97999-0967</div>
    </div>
    <div class="contact-item">
      <div class="contact-label">Localização</div>
      <div class="contact-value">Rio de Janeiro, RJ</div>
    </div>
  </div>
</section>

<!-- NEWSLETTER -->
<section class="newsletter">
  <p class="section-label reveal">Fique por dentro</p>
  <h2 class="section-title reveal">Novidades em <em>primeira mão</em></h2>
  <p style="font-size:0.82rem;color:var(--light);margin-top:0.8rem;font-weight:300" class="reveal">Receba lançamentos, promoções e inspirações direto no seu e-mail.</p>
  <div class="newsletter-form reveal">
    <input class="newsletter-input" type="email" placeholder="seu@email.com">
    <button class="newsletter-btn" onclick="subscribeNewsletter()">Inscrever</button>
  </div>
</section>

<!-- FOOTER -->
<footer>
  <div class="footer-logo">Ateliê <span>Alê&Enzo</span></div>
  <div>© 2025 Ateliê Alê&Enzo. Todos os direitos reservados.</div>
  <div style="display:flex;gap:1.5rem">
    <a href="#">Política de Privacidade</a>
    <a href="#">Trocas & Devoluções</a>
  </div>
</footer>

<!-- TOAST -->
<div id="toast"></div>

<script>
// ─── CURSOR ───────────────────────────────────────────────────────────────────
const cursor = document.getElementById('cursor');
const ring = document.getElementById('cursor-ring');
let mx = 0, my = 0, rx = 0, ry = 0;
document.addEventListener('mousemove', e => { mx = e.clientX; my = e.clientY; });
function animCursor() {
  cursor.style.left = mx + 'px'; cursor.style.top = my + 'px';
  rx += (mx - rx) * 0.12; ry += (my - ry) * 0.12;
  ring.style.left = rx + 'px'; ring.style.top = ry + 'px';
  requestAnimationFrame(animCursor);
}
animCursor();
function bindCursorHover() {
  document.querySelectorAll('a, button, .product-card, .social-link, .filter-tab, .pay-tab, .size-btn').forEach(el => {
    el.addEventListener('mouseenter', () => document.body.classList.add('cursor-hover'));
    el.addEventListener('mouseleave', () => document.body.classList.remove('cursor-hover'));
  });
}
bindCursorHover();

// ─── NAV SCROLL ───────────────────────────────────────────────────────────────
const nav = document.getElementById('mainNav');
window.addEventListener('scroll', () => nav.classList.toggle('scrolled', window.scrollY > 50));

// ─── REVEAL ───────────────────────────────────────────────────────────────────
const observer = new IntersectionObserver(entries => {
  entries.forEach(e => { if (e.isIntersecting) e.target.classList.add('visible'); });
}, { threshold: 0.1 });
document.querySelectorAll('.reveal').forEach(el => observer.observe(el));

// ─── PRODUCTS DATA ────────────────────────────────────────────────────────────
const PIX_DISCOUNT = 0.10;

const products = [
  {
    id: 1, name: 'Bolsa Tote Canvas', emoji: '👜', badge: 'Novo', cat: 'bolsas',
    desc: 'Algodão cru reforçado, ideal para o dia a dia',
    sizes: [
      { label: 'P', price: 100 },
      { label: 'M', price: 120 },
      { label: 'G', price: 140 },
    ]
  },
  {
    id: 2, name: 'Shoulder Bag', emoji: '👝', badge: null, cat: 'bolsas',
    desc: 'Couro sintético premium, alça ajustável',
    sizes: [
      { label: 'Mini', price: 130 },
      { label: 'Média', price: 150 },
    ]
  },
  {
    id: 3, name: 'Bolsa Marmita Térmica', emoji: '🍱', badge: 'Mais Vendida', cat: 'marmita',
    desc: 'Isolamento térmico, impermeável, com alça e fecho',
    sizes: [
      { label: 'P', price: 75 },
      { label: 'M', price: 95 },
      { label: 'G', price: 130 },
    ]
  },
  {
    id: 4, name: 'Nécessaire', emoji: '💼', badge: null, cat: 'acessorios',
    desc: 'Zíper duplo, interior forrado, várias estampas',
    sizes: [
      { label: 'P', price: 55 },
      { label: 'G', price: 80 },
    ]
  },
  {
    id: 5, name: 'Clutch de Festa', emoji: '✨', badge: null, cat: 'bolsas',
    desc: 'Tecido bordado à mão, forro de cetim',
    price: 110
  },
  {
    id: 6, name: 'Mochila Mini', emoji: '🎒', badge: 'Oferta', cat: 'bolsas',
    desc: 'Lona premium resistente, bolso frontal com zíper',
    price: 180
  },
  {
    id: 7, name: 'Bolsa de Praia', emoji: '🏖️', badge: null, cat: 'bolsas',
    desc: 'Juta natural + forro interno impermeável',
    price: 95
  },
  {
    id: 8, name: 'Porta-Treco', emoji: '🔑', badge: null, cat: 'acessorios',
    desc: 'Chaveiro bolsinha, diversas cores e estampas',
    price: 35
  },
];

// State: selected size per product
const selectedSizes = {};
products.forEach(p => {
  if (p.sizes) selectedSizes[p.id] = p.sizes[0].label;
});

function getProductPrice(p) {
  if (p.sizes) {
    const sz = p.sizes.find(s => s.label === selectedSizes[p.id]) || p.sizes[0];
    return sz.price;
  }
  return p.price;
}

function getPixPrice(price) {
  return price * (1 - PIX_DISCOUNT);
}

function fmt(n) {
  return n.toFixed(2).replace('.', ',');
}

// ─── RENDER PRODUCTS ─────────────────────────────────────────────────────────
function renderProducts(filter) {
  const grid = document.getElementById('productGrid');
  const filtered = filter === 'todos' ? products : products.filter(p => p.cat === filter);

  grid.innerHTML = filtered.map(p => {
    const price = getProductPrice(p);
    const pixPrice = getPixPrice(price);

    const sizesHTML = p.sizes ? `
      <div class="size-selector" id="sizes-${p.id}">
        ${p.sizes.map(s => `
          <button
            class="size-btn ${selectedSizes[p.id] === s.label ? 'active' : ''}"
            onclick="selectSize(${p.id}, '${s.label}', this)"
          >${s.label} · R$${fmt(s.price)}</button>
        `).join('')}
      </div>
    ` : '';

    return `
      <div class="product-card" data-id="${p.id}">
        <div class="product-img">
          <div class="product-emoji">${p.emoji}</div>
          ${p.badge ? `<div class="product-badge">${p.badge}</div>` : ''}
          <div class="product-overlay">
            <button class="overlay-btn" onclick="addToCart(${p.id})">Adicionar ao Carrinho</button>
          </div>
        </div>
        <div class="product-info">
          <div class="product-name">${p.name}</div>
          <div class="product-desc">${p.desc}</div>
          ${sizesHTML}
          <div class="product-footer">
            <div class="price-block">
              <div class="price-credit">Cartão: <span>R$ ${fmt(price)}</span></div>
              <div class="product-price" id="price-label-${p.id}">R$ ${fmt(price)}</div>
              <div class="price-pix" id="pix-label-${p.id}">
                💚 PIX R$ ${fmt(pixPrice)}
                <span class="price-pix-badge">−10%</span>
              </div>
            </div>
            <button class="add-cart" onclick="addToCart(${p.id})" title="Adicionar">+</button>
          </div>
        </div>
      </div>
    `;
  }).join('');

  bindCursorHover();
}

function selectSize(productId, sizeLabel, btn) {
  selectedSizes[productId] = sizeLabel;

  // Update active button
  document.querySelectorAll(`#sizes-${productId} .size-btn`).forEach(b => b.classList.remove('active'));
  btn.classList.add('active');

  // Update price display
  const p = products.find(x => x.id === productId);
  const price = getProductPrice(p);
  const pixPrice = getPixPrice(price);

  const priceLabel = document.getElementById(`price-label-${productId}`);
  const pixLabel = document.getElementById(`pix-label-${productId}`);
  if (priceLabel) priceLabel.textContent = `R$ ${fmt(price)}`;
  if (pixLabel) pixLabel.innerHTML = `💚 PIX R$ ${fmt(pixPrice)} <span class="price-pix-badge">−10%</span>`;

  // Update credit label
  const card = btn.closest('.product-card');
  if (card) {
    const creditEl = card.querySelector('.price-credit span');
    if (creditEl) creditEl.textContent = `R$ ${fmt(price)}`;
  }
}

renderProducts('todos');

function filterProducts(cat, btn) {
  document.querySelectorAll('.filter-tab').forEach(t => t.classList.remove('active'));
  btn.classList.add('active');
  renderProducts(cat);
}

// ─── CART ─────────────────────────────────────────────────────────────────────
let cartItems = [];

function addToCart(id) {
  const product = products.find(p => p.id === id);
  const sizeLabel = product.sizes ? selectedSizes[id] : null;
  const price = getProductPrice(product);

  // Check if same product+size already in cart
  const existing = cartItems.find(i => i.id === id && i.sizeLabel === sizeLabel);
  if (existing) {
    existing.qty++;
  } else {
    cartItems.push({ ...product, qty: 1, sizeLabel, price });
  }

  updateCart();
  const sizeStr = sizeLabel ? ` (${sizeLabel})` : '';
  showToast(`✓ ${product.name}${sizeStr} adicionada!`);
}

function updateCart() {
  const count = cartItems.reduce((a, i) => a + i.qty, 0);
  const countEl = document.getElementById('cart-count');
  countEl.textContent = count;
  countEl.style.display = count > 0 ? 'flex' : 'none';

  const itemsEl = document.getElementById('cartItems');
  const footerEl = document.getElementById('cartFooter');

  if (cartItems.length === 0) {
    itemsEl.innerHTML = '<div class="cart-empty"><div class="cart-empty-icon">🛍️</div><p>Seu carrinho está vazio</p></div>';
    footerEl.style.display = 'none';
    return;
  }

  footerEl.style.display = 'block';
  itemsEl.innerHTML = cartItems.map((item, idx) => {
    const pixP = getPixPrice(item.price);
    return `
      <div class="cart-item">
        <div class="cart-item-img">${item.emoji}</div>
        <div class="cart-item-info">
          <div class="cart-item-name">${item.name}</div>
          ${item.sizeLabel ? `<div class="cart-item-size">Tamanho: ${item.sizeLabel}</div>` : ''}
          <div class="cart-item-price">Cartão: R$ ${fmt(item.price)}</div>
          <div class="cart-item-pix">💚 PIX: R$ ${fmt(pixP)}</div>
          <div class="cart-item-qty">
            <button class="qty-btn" onclick="changeQty(${idx},-1)">−</button>
            <span class="qty-num">${item.qty}</span>
            <button class="qty-btn" onclick="changeQty(${idx},1)">+</button>
            <button class="remove-item" onclick="removeItem(${idx})">Remover</button>
          </div>
        </div>
      </div>
    `;
  }).join('');

  const total = cartItems.reduce((a, i) => a + i.price * i.qty, 0);
  const pixTotal = getPixPrice(total);
  document.getElementById('cartTotal').textContent = `R$ ${fmt(total)}`;
  document.getElementById('cartPixTotal').textContent = `R$ ${fmt(pixTotal)}`;

  bindCursorHover();
}

function changeQty(idx, delta) {
  cartItems[idx].qty += delta;
  if (cartItems[idx].qty <= 0) cartItems.splice(idx, 1);
  updateCart();
}
function removeItem(idx) { cartItems.splice(idx, 1); updateCart(); }

function toggleCart() {
  document.getElementById('cartSidebar').classList.toggle('open');
  document.getElementById('cartOverlay').classList.toggle('open');
}

function switchPay(type, btn) {
  document.querySelectorAll('.pay-tab').forEach(t => t.classList.remove('active'));
  document.querySelectorAll('.pay-content').forEach(c => c.classList.remove('active'));
  btn.classList.add('active');
  document.getElementById('pay-' + type).classList.add('active');
}

function copyPix() { navigator.clipboard.writeText('atelie.aleenzo@gmail.com'); showToast('Chave PIX copiada! 🎉'); }

function checkout() {
  if (cartItems.length === 0) { showToast('Seu carrinho está vazio'); return; }
  showToast('Redirecionando para o pagamento... 🔒');
}

// ─── FRETE ────────────────────────────────────────────────────────────────────
function formatCep(el) {
  let v = el.value.replace(/\D/g,'');
  if (v.length > 5) v = v.slice(0,5) + '-' + v.slice(5,8);
  el.value = v;
}

function calcFrete() {
  const cep = document.getElementById('cepInput').value.replace(/\D/g,'');
  if (cep.length < 8) { showToast('Digite um CEP válido'); return; }
  const result = document.getElementById('frete-result');
  const isLocal = ['20','21','22','23'].some(p => cep.startsWith(p));
  document.getElementById('frete-pac').textContent    = (isLocal ? 'R$ 12,50' : 'R$ 18,90') + ' (5–10 dias úteis)';
  document.getElementById('frete-sedex').textContent  = (isLocal ? 'R$ 22,00' : 'R$ 35,00') + ' (1–3 dias úteis)';
  document.getElementById('frete-moto').textContent   = isLocal ? 'R$ 15,00 (mesmo dia)' : 'Indisponível';
  result.style.display = 'block';
  showToast('Frete calculado com sucesso! 📦');
}

// ─── NEWSLETTER ───────────────────────────────────────────────────────────────
function subscribeNewsletter() { showToast('Inscrição realizada! Bem-vinda(o) 💛'); }

// ─── TOAST ────────────────────────────────────────────────────────────────────
function showToast(msg) {
  const t = document.getElementById('toast');
  t.textContent = msg;
  t.classList.add('show');
  setTimeout(() => t.classList.remove('show'), 3000);
}
</script>
</body>
</html>